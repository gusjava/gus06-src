package gus06.entity.gus.sys.script1.build.h;

import gus06.framework.*;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160504";}
	
	public static final String INPUT = "input";
	public static final String X_RETURN = "return";


	private Service engine;
	private Service contextBuilder;
	private Service getExecution;

	public EntityImpl() throws Exception
	{
		engine = Outside.service(this,"gus.sys.script1.engine");
		contextBuilder = Outside.service(this,"gus.sys.script1.context.builder1.a");
		getExecution = Outside.service(this,"gus.sys.script1.access.context.execution");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		
		if(o.length==2) return new H1(o[0],(Map) o[1],null);
		if(o.length==3) return new H1(o[0],(Map) o[1],(Map) o[2]);
		
		throw new Exception("Wrong data number: "+o.length);
	}
	
	
	
	
	private class H1 implements H
	{
		private Object src;
		private Map opMap;
		private Map data;
		
		public H1(Object src, Map opMap, Map data)
		{
			this.src = src;
			this.opMap = opMap;
			this.data = data;
		}
		
		public double h(double value) throws Exception
		{
			Map input = new HashMap();
			if(data!=null) input.putAll(data);
			input.put(INPUT,new Double(value));
			
			Map context1 = (Map) contextBuilder.t(new Object[]{input,null,opMap});
			engine.p(new Object[]{src,context1});
			
			Map execution1 = (Map) getExecution.t(context1);
			if(!execution1.containsKey(X_RETURN)) throw new Exception("Result value not found (1)");
		
			Set returnSet = (Set) execution1.remove(X_RETURN);
			if(returnSet.isEmpty()) throw new Exception("Result value not found (2)");
			
			Number r = (Number) returnSet.iterator().next();
			return r.doubleValue();
		}
	}
}
