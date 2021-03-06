package gus06.entity.gus.sys.script1.executor.type.el.r.each.map;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151115";}
	
	public static final String K_VAR = "var";
	public static final String K_WHILE = "while";
	public static final String K_UNTIL = "until";
	public static final String K_SKIP = "skip";
	public static final String K_KEEP = "keep";
	public static final String K_MAX = "max";
	public static final String K_SORT = "sort";

	
	private Service executePart1;
	private Service executePart2;
	private Service evalAsBoolean;

	public EntityImpl() throws Exception
	{
		executePart1 = Outside.service(this,"gus.sys.script1.tool.execute.content.part1");
		executePart2 = Outside.service(this,"gus.sys.script1.tool.execute.content.part2");
		evalAsBoolean = Outside.service(this,"gus.sys.script1.context.evaluate.boolean1");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=5) throw new Exception("Wrong data number: "+o.length);
			
		Map context = (Map) o[0];
		Map tag = (Map) o[1];
		Map pool1 = (Map) o[2];
		Object main = o[3];
		Map data = (Map) o[4];
		
		String var = (String) get(data,K_VAR);
		String while1 = (String) get(data,K_WHILE);
		String until1 = (String) get(data,K_UNTIL);
		String skip1 = (String) get(data,K_SKIP);
		String keep = (String) get(data,K_KEEP);
		Integer max = (Integer) get(data,K_MAX);
		Object sort = get(data,K_SORT);
		
		Map struct = (Map) main;
		Collection keys = buildKeys(struct,sort);
		
		String name_i = getIndexName(var);
		String name_k = getKeyName(var);
		String name_v = getValueName(var);
		String name_i_ = name_i + "_";
		
		int i = -1;
		
		Iterator it = keys.iterator();
		while(it.hasNext())
		{
			i++;
			Object key = it.next();
			Object value = struct.get(key);
			
			Map m = new HashMap();
			
			m.put("index",new Integer(i));
			m.put("index1",new Integer(i+1));
			m.put("size",new Integer(struct.size()));
			m.put("first",new Boolean(i==0));
			m.put("last",new Boolean(i==struct.size()-1));
			m.put("even",new Boolean(i%2==0));
			m.put("odd",new Boolean(i%2==1));
			m.put("progress",(i+1)+"/"+struct.size());
			m.put("key",key);
			m.put("value",value);
			
			pool1.put(name_i,new Integer(i));
			pool1.put(name_k,key);
			pool1.put(name_v,value);
			pool1.put(name_i_,m);
				
			
			if(while1!=null && !isTrue(context,while1)) return;
			if(until1!=null && isTrue(context,until1)) return;
			if(max!=null && i>=max.intValue()) return;
					
			if(skip1==null || !isTrue(context,skip1))
			if(keep==null || isTrue(context,keep))
			{
				executePart1.p(new Map[]{tag,context});
			}
		}
		if(struct.isEmpty())
		{
			executePart2.p(new Map[]{tag,context});
		}
	}
	
	
	
	private Collection buildKeys(Map struct, Object sort) throws Exception
	{
		if(sort==null)
			return struct.keySet();
		if(sort.equals(Boolean.TRUE))
			return sortedList(struct.keySet());
		if(sort.equals("keys"))
			return sortedList(struct.keySet());
		if(sort.equals("values"))
			return sortedList(struct.keySet(),new Comparator1(struct));
		
		throw new Exception("Invalid sort value: "+sort);
	}
	
	
	private List sortedList(Collection c)
	{
		List list = new ArrayList(c);
		Collections.sort(list);
		return list;
	}
	
	private List sortedList(Collection c, Comparator k)
	{
		List list = new ArrayList(c);
		Collections.sort(list,k);
		return list;
	}
	
	
	
	
	private Object get(Map map, String key)
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
	
	
	
	private String getKeyName(String var)
	{
		if(var==null) return "k";
		var = var.split(":")[0];
		return var.split("->")[0];
	}
	
	private String getValueName(String var)
	{
		if(var==null) return "v";
		var = var.split(":")[0];
		return var.split("->")[1];
	}
	
	private String getIndexName(String var)
	{
		if(var==null) return "i";
		if(!var.contains(":")) return "i";
		return var.split(":")[1];
	}
	
	
	private boolean isTrue(Map context, String rule) throws Exception
	{
		Boolean b = (Boolean) evalAsBoolean.t(new Object[]{context,rule});
		return b.booleanValue();
	}
	
	
	private class Comparator1 implements Comparator
	{
		private Map m;
		public Comparator1(Map m){this.m = m;}
		
		public int compare(Object o1, Object o2)
		{
			Comparable v1 = (Comparable) m.get(o1);
			Comparable v2 = (Comparable) m.get(o2);
			return v1.compareTo(v2);
		}
	}
}
