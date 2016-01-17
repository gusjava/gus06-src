package gus06.entity.gus.sys.script1.executor.type.el.r.each.map;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151115";}

	
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
		if(o.length!=8) throw new Exception("Wrong data number: "+o.length);
		
		Map tag = (Map) o[0];
		Map context = (Map) o[1];
		Map pool = (Map) o[2];
		Map struct = (Map) o[3];
		String var = (String) o[4];
		String while1 = (String) o[5];
		String until1 = (String) o[6];
		String skip1 = (String) o[7];
		
		
		Iterator it = struct.keySet().iterator();
		
		String name_i = getIndexName(var);
		String name_k = getKeyName(var);
		String name_v = getValueName(var);
		
		int i = -1;
		
		while(it.hasNext())
		{
			i++;
			Object key = it.next();
			Object value = struct.get(key);
					
			pool.put(name_i,new Integer(i));
			pool.put(name_k,key);
			pool.put(name_v,value);
			
			if(while1!=null && !isTrue(context,while1)) return;
			if(until1!=null && isTrue(context,until1)) return;
					
			if(skip1==null || !isTrue(context,skip1))
			executePart1.p(new Map[]{tag,context});
		}
		if(struct.isEmpty())
		{
			pool.put(name_i,new Integer(-1));
			executePart2.p(new Map[]{tag,context});
		}
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
}
