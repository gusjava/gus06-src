package gus06.entity.gus.string.transform.url.sendpost;

import gus06.framework.*;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150314";}


	private Service send;

	public EntityImpl() throws Exception
	{send = Outside.service(this,"gus.web.httprequest.post.send");}
	
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split("\n",-1);
		if(n.length<2) throw new Exception("Invalid input: "+s);
		
		URL url = new URL(n[0]);
		
		Map map = new HashMap();
		for(int i=1;i<n.length;i++)
		{
			String[] k = n[i].split(":",2);
			map.put(k[0],k[1]);
		}
		return send(url,map);
	}
	
	
	private String send(URL url, Map map) throws Exception
	{
		send.v("map",map);
		
		try{return (String) send.t(url);}
		catch(Exception e)
		{return e.toString();}
	}
}
