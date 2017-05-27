package gus06.entity.gus.sys.expression1.apply.op._crawler1;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170114";}
	
	public static final String KEY_E0 = "e0";
	public static final String KEY_T = "t";
	public static final String KEY_F = "f";

	
	
	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.sys.crawler1.engine");
	}

	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Map) return build((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	private Object build(Map map) throws Exception
	{
		Object e0 = get1(map,KEY_E0);
		T t = (T) get1(map,KEY_T);
		F f = (F) get(map,KEY_F);
		
		return perform.t(new Object[]{e0,t,f});
	}
	
	
	
	private Object get(Map map, String key)
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
	
	private Object get1(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) throw new Exception("Key not found inside map: "+key);
		return map.get(key);
	}
}
