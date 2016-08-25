package gus06.entity.gus.sys.script1.executor.type.el.r.for1;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150829";}

	public static final String K_VAR = "var";
	public static final String K_WHILE = "while";
	public static final String K_UNTIL = "until";
	public static final String K_SKIP = "skip";
	public static final String K_KEEP = "keep";
	public static final String K_MAX = "max";
	
	
	private Service buildRange;
	private Service evalAsBoolean;
	private Service executePart1;
	private Service executePart2;
	private Service wrapping1;
	

	public EntityImpl() throws Exception
	{
		buildRange = Outside.service(this,"gus.sys.script1.executor.type.el.r.for1.range");
		evalAsBoolean = Outside.service(this,"gus.sys.script1.context.evaluate.boolean1");
		executePart1 = Outside.service(this,"gus.sys.script1.tool.execute.content.part1");
		executePart2 = Outside.service(this,"gus.sys.script1.tool.execute.content.part2");
		wrapping1 = Outside.service(this,"gus.sys.script1.tool.execute.wrapping1");
	}
	
	
	
	
	public Object t(Object obj) throws Exception
	{return new Executor((Map) obj);}
	
	
	
	
	private class Executor implements P
	{
		private Map tag;
		public Executor(Map tag) {this.tag = tag;}
		
		public void p(Object obj) throws Exception
		{
			Map context = (Map) obj;
			wrapping1.p(new Object[]{context,tag,new Wrap()});
		}
	}
	
	
	private class Wrap implements P
	{
		public void p(Object obj) throws Exception
		{
			Object[] o = (Object[]) obj;
			if(o.length!=5) throw new Exception("Wrong data number: "+o.length);
			
			Map context = (Map) o[0];
			Map tag = (Map) o[1];
			Map pool1 = (Map) o[2];
			Object main = o[3];
			Map data = (Map) o[4];
			
			
			int[] range = (int[]) buildRange.t(main);
			String var = (String) get(data,K_VAR);
			String while1 = (String) get(data,K_WHILE);
			String until1 = (String) get(data,K_UNTIL);
			String skip1 = (String) get(data,K_SKIP);
			String keep = (String) get(data,K_KEEP);
			Integer max = (Integer) get(data,K_MAX);
			
			String mName1 = var!=null?var:"i";
			String mName2 = mName1 + "_";
			
			if(range!=null)
			{
				int start = range[0];
				int end = range[1];
				int incr = range[2];
				int times = (int) ((end-start)/incr);
				
				boolean endFound = false;
				for(int i=start;!endFound;i+=incr)
				{
					Map m = new HashMap();
					
					m.put("index",new Integer(i));
					m.put("times",new Integer(times));
					m.put("start",new Integer(start));
					m.put("end",new Integer(end));
					m.put("incr",new Integer(incr));
					m.put("first",new Boolean(i==start));
					m.put("last",new Boolean(i==end));
					
					pool1.put(mName1,new Integer(i));
					pool1.put(mName2,m);
					
					if(while1!=null && !isTrue(context,while1)) break;
					if(until1!=null && isTrue(context,until1)) break;
					if(max!=null && i>=max.intValue()) break;
					
					if(skip1==null || !isTrue(context,skip1))
					if(keep==null || isTrue(context,keep))
					executePart1.p(new Map[]{tag,context});
					
					endFound = i==end;
				}
			}
			else
			{
				executePart2.p(new Map[]{tag,context});
			}
		}
	}
	
	
	
	private Object get(Map map, String key)
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
	
	private boolean isTrue(Map context, String rule) throws Exception
	{
		Boolean b = (Boolean) evalAsBoolean.t(new Object[]{context,rule});
		return b.booleanValue();
	}
}
