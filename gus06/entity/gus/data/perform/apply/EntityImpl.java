package gus06.entity.gus.data.perform.apply;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160710";}


	private Service wrap_pobj;

	public EntityImpl() throws Exception
	{
		wrap_pobj = Outside.service(this,"gus.feature.wrap.pobj.e");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		return apply(o[0],o[1]);
	}
	
	
	private Object apply(Object o1, Object o2) throws Exception
	{
		if(o1==null) throw new Exception("o1 is null");
		
		if(o1 instanceof T) return ((T) o1).t(o2);
		if(o1 instanceof R) return ((R) o1).r((String) o2);
		if(o1 instanceof F) return new Boolean(((F) o1).f(o2));
		if(o1 instanceof H) return new Double(((H) o1).h(toDouble(o2)));
		if(o1 instanceof P) return wrap_pobj.t(new Object[]{o1,o2});
	
		if(o1 instanceof Map) return get((Map) o1,o2);
		if(o1 instanceof List) return get((List) o1,toInt(o2));
		if(o1 instanceof Set) return new Boolean(has((Set) o1,o2));
	
		throw new Exception("Invalid data type: "+o1.getClass().getName());
	}
	
	
	private double toDouble(Object obj)
	{return Double.parseDouble(""+obj);}
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
	
	private Object get(Map map, Object key)
	{return map.containsKey(key)?map.get(key):null;}
	
	private boolean has(Set set, Object value)
	{return set.contains(value);}
	
	private Object get(List list, int index)
	{
		int size = list.size();
		if(index<0) index = size+index;
		if(index<0 || index>=size) return null;
		return list.get(index);
	}
}
