package gus06.entity.gus.sys.script1.executor.type.el.r.try1;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151117";}
	
	public static final String K_ARGS = "args";
	public static final String K_REPEAT = "repeat";
	public static final String K_REDIRECT = "redirect";
	public static final String K_IF = "if";


	private Service getParams;
	private Service getOutput;
	private Service stackManager;
	private Service buildData;
	private Service evalAsBoolean;
	
	private Service executePart1;
	private Service executePart2;
	
	
	
	public EntityImpl() throws Exception
	{
		getParams = Outside.service(this,"gus.sys.script1.access.tag.params0");
		getOutput = Outside.service(this,"gus.sys.script1.access.context.output0");
		stackManager = Outside.service(this,"gus.sys.script1.context.stack.manager");
		buildData = Outside.service(this,"gus.sys.script1.executor.type.el.r.try1.params");
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
			
			Integer repeat = (Integer) get(data,K_REPEAT);
			Map args = (Map) get(data,K_ARGS);
			Object redirect = get(data,K_REDIRECT);
			Boolean if1 = (Boolean) get(data,K_IF);
			
			
			if(if1!=null && !if1.booleanValue()) return;
			
			if(redirect!=null) output.v("redirect",redirect);
			
			E stack = stack(context,tag);
			Map pool1 = pool1(stack);
			
			if(args!=null) pool1.putAll(args);
			
			int n = repeat!=null?repeat.intValue():1;
			
			for(int i=0;i<n;i++)
			try
			{
				executePart1.p(new Map[]{tag,context});
			}
			catch(Exception e)
			{
				pool1.put("e",e);
				executePart2.p(new Map[]{tag,context});
			}
			
			stack.e();
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
