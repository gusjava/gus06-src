package gus06.entity.gus.jdbc.mysql.sql.where;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170202";}


	private Service formatName;
	private Service formatValue;
	
	
	public EntityImpl() throws Exception
	{
		formatName = Outside.service(this,"gus.jdbc.mysql.format.sql.name");
		formatValue = Outside.service(this,"gus.jdbc.mysql.format.sql.value");
	}

	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof String) return obj;
		if(obj instanceof Map) return fromMap((Map) obj);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private String fromMap(Map map) throws Exception
	{
		StringBuffer b = new StringBuffer();
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			Object value = map.get(key);
			
			if(b.length()>0) b.append("AND ");
			b.append(formatName(key));
			b.append("=");
			b.append(formatValue(value));
		}
		return b.toString();
	}
	
	
	private String formatName(String name) throws Exception
	{return (String) formatName.t(name);}
	
	private String formatValue(Object value) throws Exception
	{return (String) formatValue.t(value);}
}
