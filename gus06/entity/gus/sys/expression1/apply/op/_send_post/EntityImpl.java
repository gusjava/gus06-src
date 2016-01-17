package gus06.entity.gus.sys.expression1.apply.op._send_post;

import gus06.framework.*;
import java.util.Map;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151126";}
	
	public static final String KEY_URL = "_URL";
	public static final String KEY_COOKIE = "_COOKIE";
	public static final String KEY_USER = "_USER";
	public static final String KEY_PWD = "_PWD";
	
	
	
	private Service send;
	private Service toURL;

	public EntityImpl() throws Exception
	{
		send = Outside.service(this,"gus.web.httprequest.post.send");
		toURL = Outside.service(this,"gus.find.url");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Map) return send((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private Object send(Map map) throws Exception
	{
		URL url = findURL(map);
		String cookie = findCookie(map);
		String[] auth = findAuth(map);
		
		send.v("map",map);
		send.v("cookie",cookie);
		send.v("auth",auth);
		
		try{return (String) send.t(url);}
		catch(Exception e) {return e;}
	}
	
	
	
	private URL findURL(Map map) throws Exception
	{
		Object o = getAndRemove(map,KEY_URL);
		if(o==null) throw new Exception("URL not found inside map");
		return (URL) toURL.t(o);
	}
	
	
	private String findCookie(Map map) throws Exception
	{
		return (String) getAndRemove(map,KEY_COOKIE);
	}
	
	
	private String[] findAuth(Map map) throws Exception
	{
		String user = (String) getAndRemove(map,KEY_USER);
		if(user==null) return null;
		
		String pwd = (String) getAndRemove(map,KEY_PWD);
		if(pwd==null) return null;
		
		return new String[]{user,pwd};
	}
	
	
	private Object getAndRemove(Map map, String key)
	{
		if(!map.containsKey(key)) return null;
		Object v = map.get(key);
		map.remove(key);
		return v;
	}
}
