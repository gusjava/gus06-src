package gus06.entity.gus.tostring.map.urlencoding;

import java.util.Map;
import gus06.framework.*;
import java.util.Iterator;
import java.net.URLEncoder;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170130";}



	public Object t(Object obj) throws Exception
	{return mapToString((Map) obj);}
	
	
	
	private String mapToString(Map map) throws Exception
	{
		StringBuffer b = new StringBuffer();
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			String value = (String) map.get(key);
			append(b,key,value);
		}
		return b.toString();
	}
	
	
	
	private void append(StringBuffer b, String key, String value) throws Exception
	{
		try
		{
			String bloc = format(key)+"="+format(value);
			if(b.length()>0) b.append("&");
			b.append(bloc);
		}
		catch(Exception e)
		{
			String message = "Building input failed for key="+key+" and value="+value;
			throw new Exception(message,e);
		}
	}

	
	private String format(String data) throws Exception
	{return URLEncoder.encode(data,"UTF-8");}
}
