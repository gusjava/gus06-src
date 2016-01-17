package gus06.entity.gus.sys.script1.context.builder1;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Arrays;

public class EntityImpl implements Entity, T {
	
	public static final String C_ALIAS = "alias";
	public static final String C_POOL = "pool";
	public static final String C_INPUT = "input";
	public static final String C_OUTPUT = "output";
	public static final String C_HISTORY = "history";
	public static final String C_LEVEL = "level";
	public static final String C_APP = "app";
	
	public static final String C_TAG_BUILDER = "tag_builder";
	public static final String C_TAG_EXECUTOR = "tag_executor";
	public static final String C_EXP_EVALUATOR = "exp_evaluator";
	public static final String C_EXP_OPERATORS = "exp_operators";
	
	public static final String P_CONTEXT = "context";
	public static final String P_RESERVED = "reserved";
	public static final String P_PARENT = "parent";
	public static final String P_SCRIPT = "script";
	
	
	
	public static final List RESERVED = Arrays.asList(new String[]{
		P_RESERVED,P_CONTEXT,P_PARENT,P_SCRIPT
	});
	


	public String creationDate() {return "20150901";}


	private Service buildOutput;
	private Service buildInput;
	private Service buildMap;
	private Service buildList;
	
	private Service tagBuilder;
	private Service tagExecutor;
	private Service expEvaluator;
	private Service opMap;
	private Service appMap;

	

	public EntityImpl() throws Exception
	{
		buildOutput = Outside.service(this,"gus.sys.script1.context.builder1.output");
		buildInput = Outside.service(this,"gus.sys.script1.context.builder1.input");
		buildMap = Outside.service(this,"gus.map.map1");
		buildList = Outside.service(this,"gus.list.list1");
		
		tagBuilder = Outside.service(this,"gus.sys.script1.tool.build.tag");
		tagExecutor = Outside.service(this,"gus.sys.script1.tool.execute.tag");
		expEvaluator = Outside.service(this,"gus.sys.expression1.evaluate");
		opMap = Outside.service(this,"gus.sys.expression1.apply.opmap");
		appMap = Outside.service(this,"gus.sys.script1.context.builder1.app");
	}
	

	
	public Object t(Object obj) throws Exception
	{
		Object input = null;
		Object output = null;
		
		if(obj instanceof Object[])
		{
			Object[] o = (Object[]) obj;
			if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
			
			input = o[0];
			output = o[1];
		}
		else output = obj;
		
		
		Map context = map("context");
		Map pool = map("pool");
		Map alias = map("alias");
		List history = list("history");
		
		Map op = (Map) opMap.g();
		Map app = (Map) appMap.g();
		
		input = buildInput.t(input);
		output = buildOutput.t(output);
		
		if(input!=null) context.put(C_INPUT,input);
		if(output!=null) context.put(C_OUTPUT,output);
		
		context.put(C_POOL,pool);
		context.put(C_ALIAS,alias);
		context.put(C_HISTORY,history);
		context.put(C_LEVEL,new Integer(0));
		context.put(C_APP,app);
		
		context.put(C_TAG_BUILDER,tagBuilder);
		context.put(C_TAG_EXECUTOR,tagExecutor);
		context.put(C_EXP_EVALUATOR,expEvaluator);
		context.put(C_EXP_OPERATORS,op);
		
		pool.put(P_CONTEXT,context);
		pool.put(P_RESERVED,RESERVED);
		
		return context;
	}
	
	
	private Map map(String name) throws Exception
	{return (Map) buildMap.t(name);}
	
	private List list(String name) throws Exception
	{return (List) buildList.t(name);}
}
