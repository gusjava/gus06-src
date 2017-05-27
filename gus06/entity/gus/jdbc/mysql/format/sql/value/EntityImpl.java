package gus06.entity.gus.jdbc.mysql.format.sql.value;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141009";}


	public final static int LIMITSIZE = 65535;
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof String) return formatString((String) obj);
		if(obj instanceof Number) return formatNumber((Number) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private String formatString(String value)
	{
		if(value.length()>LIMITSIZE) value = value.substring(0,LIMITSIZE);
		return "'"+value.replace("\\","\\\\").replace("'","\\'")+"'";
	}
	
	private String formatNumber(Number value)
	{
		return value.toString();
	}
}
