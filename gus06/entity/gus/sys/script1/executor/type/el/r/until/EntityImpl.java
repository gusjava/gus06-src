package gus06.entity.gus.sys.script1.executor.type.el.r.until;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160110";}
	
	public static final String K_WHILE = "while";
	public static final String K_SKIP = "skip";
	public static final String K_KEEP = "keep";
	public static final String K_MIN = "min";
	public static final String K_MAX = "max";
	
	public static final int LIMIT = 100000;

	
	private Service evalAsBoolean;
	private Service executePart1;
	private Service executePart2;
	private Service wrapping1;
	private Service getMain;

	public EntityImpl() throws Exception
	{
		evalAsBoolean = Outside.service(this,"gus.sys.script1.context.evaluate.boolean1");
		executePart1 = Outside.service(this,"gus.sys.script1.tool.execute.content.part1");
		executePart2 = Outside.service(this,"gus.sys.script1.tool.execute.content.part2");
		wrapping1 = Outside.service(this,"gus.sys.script1.tool.execute.wrapping1");
		getMain = Outside.service(this,"gus.sys.script1.tool.execute.params.handler1.a.main");
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
			
			
			Boolean until1 = (Boolean) main;
			String while1 = (String) get(data,K_WHILE);
			String skip1 = (String) get(data,K_SKIP);
			String keep = (String) get(data,K_KEEP);
			Integer min = (Integer) get(data,K_MIN);
			Integer max = (Integer) get(data,K_MAX);
			
			int limit = max!=null ? max.intValue() : LIMIT;
			
			int k = 0;
			
			if(min!=null)
			for(int i=0;i<min.intValue();i++)
			{
				executePart1.p(new Map[]{tag,context});
				k++;
			}
			
			if(k>0)	until1 = evalMain(context,tag);
			
			while(!until1.booleanValue() && k<=limit)
			{
				if(while1!=null && !isTrue(context,while1)) break;
				
				if(skip1==null || !isTrue(context,skip1))
				if(keep==null || isTrue(context,keep))
				executePart1.p(new Map[]{tag,context});
				
				k++;
				until1 = evalMain(context,tag);
			}
			
			if(k==0) executePart2.p(new Map[]{tag,context});
			else if(k>LIMIT && max==null) throw new Exception("Infinite loop detected");
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
	
	
	private Boolean evalMain(Map context, Map tag) throws Exception
	{
		return (Boolean) getMain.t(new Object[]{context,tag});
	}
}
