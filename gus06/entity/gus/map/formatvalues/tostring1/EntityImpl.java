package gus06.entity.gus.map.formatvalues.tostring1;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150527";}


	private Service format;


	public EntityImpl() throws Exception
	{
		format = Outside.service(this,"gus.tostring.tostring1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) obj;
		Map map1 = new HashMap();
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			String value = format(map.get(key));
			map1.put(key,value);
		}
		return map1;
	}
	
	
	private String format(Object obj) throws Exception
	{return (String) format.t(obj);}
}
