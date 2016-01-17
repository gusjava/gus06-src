package gus06.entity.gus.sys.script1.executor.type.el.r.for1;

import gus06.framework.*;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150829";}

	public static final String K_RANGE = "range";
	public static final String K_ARGS = "args";
	public static final String K_VAR = "var";
	public static final String K_REDIRECT = "redirect";
	public static final String K_WHILE = "while";
	public static final String K_UNTIL = "until";
	public static final String K_SKIP = "skip";
	public static final String K_IF = "if";
	
	
	private Service getParams;
	private Service getOutput;
	private Service evalAsInt;
	private Service stackManager;
	private Service buildData;
	private Service buildRange;
	private Service evalAsBoolean;
	
	private Service executePart1;
	private Service executePart2;
	

	public EntityImpl() throws Exception
	{
		getParams = Outside.service(this,"gus.sys.script1.access.tag.params1");
		getOutput = Outside.service(this,"gus.sys.script1.access.context.output0");
		stackManager = Outside.service(this,"gus.sys.script1.context.stack.manager");
		buildData = Outside.service(this,"gus.sys.script1.executor.type.el.r.for1.params");
		buildRange = Outside.service(this,"gus.sys.script1.executor.type.el.r.for1.range");
		evalAsBoolean = Outside.service(this,"gus.sys.script1.context.evaluate.boolean1");
		
		executePart1 = Outside.service(this,"gus.sys.script1.tool.execute.content.part1");
		executePart2 = Outside.service(this,"gus.sys.script1.tool.execute.content.part2");
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
			String params = (String) getParams.t(tag);
			V output = (V) getOutput.t(context);
			Object p0 = ((R) output).r("p0");
			
			Map data = (Map) buildData.t(new Object[]{context,params});
			
			int[] range = (int[]) buildRange.t(get(data,K_RANGE));
			Map args = (Map) get(data,K_ARGS);
			String var = (String) get(data,K_VAR);
			
			Object redirect = get(data,K_REDIRECT);
			String while1 = (String) get(data,K_WHILE);
			String until1 = (String) get(data,K_UNTIL);
			String skip1 = (String) get(data,K_SKIP);
			Boolean if1 = (Boolean) get(data,K_IF);
			
			
			if(if1!=null && !if1.booleanValue()) return;
			
			if(redirect!=null) output.v("redirect",redirect);
			
			E stack = stack(context,tag);
			Map pool1 = pool1(stack);
			
			if(args!=null) pool1.putAll(args);
			
			String mName = var!=null?var:"i";
			
			if(range!=null)
			{
				int start = range[0];
				int end = range[1];
				int incr = range[2];
				
				boolean endFound = false;
				for(int i=start;!endFound;i+=incr)
				{
					pool1.put(mName,new Integer(i));
					
					if(while1!=null && !isTrue(context,while1)) break;
					if(until1!=null && isTrue(context,until1)) break;
					
					if(skip1==null || !isTrue(context,skip1))
					executePart1.p(new Map[]{tag,context});
					endFound = i==end;
				}
			}
			else executePart2.p(new Map[]{tag,context});
			
			stack.e();
			
			if(redirect!=null) output.v("redirect",p0);
		}
	}
	
	
	private Object get(Map map, String key)
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
	
	private E stack(Map context, Map tag) throws Exception
	{return (E) stackManager.t(new Map[]{context,tag});}
	
	private Map pool1(Object stack) throws Exception
	{return (Map) ((G) stack).g();}
	
	
	private boolean isTrue(Map context, String rule) throws Exception
	{
		Boolean b = (Boolean) evalAsBoolean.t(new Object[]{context,rule});
		return b.booleanValue();
	}
	
	
	
	
	
	
	

}
