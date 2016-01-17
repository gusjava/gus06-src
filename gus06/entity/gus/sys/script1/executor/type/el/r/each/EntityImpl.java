package gus06.entity.gus.sys.script1.executor.type.el.r.each;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151111";}

	public static final String K_SRC = "src";
	public static final String K_ARGS = "args";
	public static final String K_VAR = "var";
	public static final String K_REPEAT = "repeat";
	public static final String K_REDIRECT = "redirect";
	public static final String K_WHILE = "while";
	public static final String K_UNTIL = "until";
	public static final String K_SKIP = "skip";
	public static final String K_IF = "if";

	
	private Service getParams;
	private Service getOutput;
	private Service stackManager;
	private Service buildData;
	
	private Service each_map;
	private Service each_set;
	private Service each_list;
	private Service each_array;


	public EntityImpl() throws Exception
	{
		getParams = Outside.service(this,"gus.sys.script1.access.tag.params1");
		getOutput = Outside.service(this,"gus.sys.script1.access.context.output0");
		stackManager = Outside.service(this,"gus.sys.script1.context.stack.manager");
		buildData = Outside.service(this,"gus.sys.script1.executor.type.el.r.each.params");
		
		each_map = Outside.service(this,"gus.sys.script1.executor.type.el.r.each.map");
		each_set = Outside.service(this,"gus.sys.script1.executor.type.el.r.each.set");
		each_list = Outside.service(this,"gus.sys.script1.executor.type.el.r.each.list");
		each_array = Outside.service(this,"gus.sys.script1.executor.type.el.r.each.array");
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
			
			Object src = get(data,K_SRC);
			Map args = (Map) get(data,K_ARGS);
			String var = (String) get(data,K_VAR);
			Integer repeat = (Integer) get(data,K_REPEAT);
			Object redirect = get(data,K_REDIRECT);
			String while1 = (String) get(data,K_WHILE);
			String until1 = (String) get(data,K_UNTIL);
			String skip1 = (String) get(data,K_SKIP);
			Boolean if1 = (Boolean) get(data,K_IF);
			
			Service eachS = findService(src);
			
			
			if(if1!=null && !if1.booleanValue()) return;
			
			if(redirect!=null) output.v("redirect",redirect);
			
			E stack = stack(context,tag);
			Map pool1 = pool1(stack);
			
			if(args!=null) pool1.putAll(args);
			
			int times = repeat!=null?repeat.intValue():1;
			if(times<0) times = 0;
			
			for(int i=0;i<times;i++)
			eachS.p(new Object[]{tag,context,pool1,src,var,while1,until1,skip1});
			
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
	
	
	
	private Service findService(Object src) throws Exception
	{
		if(src instanceof Map) return each_map;
		if(src instanceof Set) return each_set;
		if(src instanceof List) return each_list;
		if(src instanceof Object[]) return each_array;
		
		throw new Exception("Invalid data type: "+src.getClass().getName());
	}
}
