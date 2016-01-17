package gus06.entity.gus.sys.parser3.resolver1.op.binary.power;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}


	private Service longest;

	public EntityImpl() throws Exception
	{
		longest = Outside.service(this,"gus.data.compare.string.common.longest1");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List[] cut = (List[]) o[0];
		T t = (T) o[1];
		
		if(cut.length!=2) throw new Exception("Invalid split for equals operation: "+cut.length);
		
		
		Object o1 = t.t(cut[0]);
		Object o2 = t.t(cut[1]);
		
		if(o1 instanceof Boolean && o2 instanceof Boolean)
			return bool_xor((Boolean)o1,(Boolean)o2);
			
		if(o1 instanceof Integer && o2 instanceof Integer)
			return int_power((Integer)o1,(Integer)o2);
			
		if(o1 instanceof Number && o2 instanceof Number)
			return num_power((Number)o1,(Number)o2);
			
		if(o1 instanceof Set && o2 instanceof Set)
			return set_inter((Set)o1,(Set)o2);
			
		if(o1 instanceof Map && o2 instanceof Map)
			return map_inter((Map)o1,(Map)o2);
			
		if(o1 instanceof String && o2 instanceof String)
			return str_longest((String)o1,(String)o2);
		
		throw new Exception("Invalid power operation");
	}
	
	
	private Boolean bool_xor(Boolean b1, Boolean b2)
	{
		return new Boolean(b1.booleanValue() ^ b2.booleanValue());
	}
	
	private Integer int_power(Integer n1, Integer n2)
	{
		double r = Math.pow(n1.intValue(),n2.intValue());
		return new Integer((int) r);
	}
	
	private Double num_power(Number n1, Number n2)
	{
		double r = Math.pow(n1.doubleValue(),n2.doubleValue());
		return new Double(r);
	}
	
	private Set set_inter(Set s1, Set s2)
	{
		Set s = new HashSet(s1);
		s.retainAll(s2);
		return s;
	}
	
	private Map map_inter(Map m1, Map m2)
	{
		Map m = new HashMap();
		Iterator it = m1.keySet().iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			if(m2.containsKey(key))
			{
				Object value1 = m1.get(key);
				Object value2 = m2.get(key);
				if(value1.equals(value2)) m.put(key,value1);
			}
		}
		return m;
	}
	
	
	private String str_longest(String s1, String s2) throws Exception
	{return (String) longest.t(new String[]{s1,s2});}
	
}
