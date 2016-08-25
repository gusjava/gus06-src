package gus06.entity.gus.sys.expression1.apply.op._tomap;

import gus06.framework.*;
import java.util.Set;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160129";}


	private Service rToMap;
	private Service tToMap;
	
	
	public EntityImpl() throws Exception
	{
		rToMap = Outside.service(this,"gus.convert.rtomap");
		tToMap = Outside.service(this,"gus.convert.ttomap");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Map) return obj;
		if(obj instanceof Set) return fromSet((Set) obj);
		if(obj instanceof List) return fromList((List) obj);
		if(obj instanceof Object[]) return fromArray((Object[]) obj);
		if(obj instanceof R) return rToMap.t(obj);
		if(obj instanceof T) return tToMap.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private Map fromSet(Set set)
	{
		Map m = new HashMap();
		Iterator it = set.iterator();
		while(it.hasNext())
		{
			Object element = it.next();
			m.put(element,element);
		}
		return m;
	}
	
	private Map fromList(List list)
	{
		Map m = new HashMap();
		for(int i=0;i<list.size();i++)
		m.put(new Integer(i),list.get(i));
		return m;
	}
	
	private Map fromArray(Object[] array)
	{
		Map m = new HashMap();
		for(int i=0;i<array.length;i++)
		m.put(new Integer(i),array[i]);
		return m;
	}
}
