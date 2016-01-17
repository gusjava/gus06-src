package gus06.entity.gus.app.persister1.counter;

import gus06.framework.*;

public class EntityImpl implements Entity, R {

	public String creationDate() {return "20140918";}


	private Service persister1;


	public EntityImpl() throws Exception
	{
		persister1 = Outside.service(this,"gus.app.persister1");
	}
	
	
	public Object r(String key) throws Exception
	{
		String value = (String) persister1.r(key);
		int count = toInt(value,key);
		persister1.v(key,""+(count+1));
		return ""+count;
	}
	
	
	
	private int toInt(String value, String key) throws Exception
	{
		if(value==null || value.equals("")) return 0;
		try
		{
			return Integer.parseInt(value);
		}
		catch(NumberFormatException e)
		{
			String message = "Failed to read counter value for key: "+key+" (value="+value+")";
			throw new Exception(message,e);
		}
	}
}
