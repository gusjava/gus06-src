package gus06.entity.gus.app.cache.counter;

import gus06.framework.*;

public class EntityImpl implements Entity, R {

	public String creationDate() {return "20170320";}


	private Service cache;

	public EntityImpl() throws Exception
	{
		cache = Outside.service(this,"gus.app.cache");
	}
	
	
	public Object r(String key) throws Exception
	{
		Integer value = (Integer) cache.r(key);
		int count = toInt(value);
		cache.v(key,new Integer(count+1));
		return ""+count;
	}
	
	
	private int toInt(Integer value)
	{return value!=null ? value.intValue() : 0;}
}
