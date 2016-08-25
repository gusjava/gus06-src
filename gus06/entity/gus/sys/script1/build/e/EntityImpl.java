package gus06.entity.gus.sys.script1.build.e;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160504";}
	

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
		
		return new E1(src,opMap);
	}
	
	
	
	
	private class E1 implements E
	{
		private Object src;
		private Map opMap;
		
		public E1(Object src, Map opMap)
		{
			this.src = src;
			this.opMap = opMap;
		}
		
		public void e() throws Exception
		{
			Map context1 = (Map) contextBuilder.t(new Object[]{null,null,opMap});
			engine.p(new Object[]{src,context1});
		}
	}
}
