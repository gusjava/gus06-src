package gus06.entity.gus.sys.expression1.apply.op._put;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20160107";}
	
	private Service findNumber;
	
	public EntityImpl() throws Exception
	{findNumber = Outside.service(this,"gus.find.number");}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Map) return new T1((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("input")) return new Class[]{Map.class};
		if(key.equals("output")) return new Class[]{T.class};
		
		if(key.equals("keys")) return new String[]{"input","output"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	private class T1 implements T
	{
		private Map map;
		public T1(Map map) {this.map = map;}
		
		public Object t(Object obj) throws Exception
		{return new P1(map,obj);}
	}
	
	
	
	private class P1 implements P
	{
		private Map map;
		private Object key;
		
		public P1(Map map, Object key)
		{
			this.map = map;
			this.key = key;
		}
		
		public void p(Object obj) throws Exception
		{map.put(key,obj);}
	}
}
