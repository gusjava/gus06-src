package gus06.entity.gus.sys.script1.build.p;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160504";}
	
	public static final String INPUT = "input";


	private Service engine;
	private Service contextBuilder;


	public EntityImpl() throws Exception
	{
		engine = Outside.service(this,"gus.sys.script1.engine");
		contextBuilder = Outside.service(this,"gus.sys.script1.context.builder1.a");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object src = o[0];
		Map opMap = (Map) o[1];
		
		return new P1(src,opMap);
	}
	
	
	
	
	private class P1 implements P
	{
		private Object src;
		private Map opMap;
		
		public P1(Object src, Map opMap)
		{
			this.src = src;
			this.opMap = opMap;
		}
		
		public void p(Object obj) throws Exception
		{
			Map input = new HashMap();
			input.put(INPUT,obj);
			
			Map context1 = (Map) contextBuilder.t(new Object[]{input,null,opMap});
			engine.p(new Object[]{src,context1});
		}
	}
}
