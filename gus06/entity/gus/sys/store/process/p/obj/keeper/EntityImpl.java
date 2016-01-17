package gus06.entity.gus.sys.store.process.p.obj.keeper;

import gus06.framework.*;
import java.util.HashMap;

public class EntityImpl implements Entity, R, V, G {

	public String creationDate() {return "20140907";}


	private HashMap map;

	public EntityImpl() throws Exception
	{map = new HashMap();}
	
	
	public Object g() throws Exception
	{return map;}
	
	
	public Object r(String key) throws Exception
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
	
	
	public void v(String key, Object obj) throws Exception
	{map.put(key,obj);}
}
