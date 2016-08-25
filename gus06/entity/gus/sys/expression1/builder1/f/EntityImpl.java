package gus06.entity.gus.sys.expression1.builder1.f;

import gus06.framework.*;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151031";}

	private Service prepare;
	private Service resolver1;
	private Service buildExternal;

	public EntityImpl() throws Exception
	{
		prepare = Outside.service(this,"gus.sys.parser3.prepare");
		resolver1 = Outside.service(this,"gus.sys.parser3.resolver1");
		buildExternal = Outside.service(this,"gus.sys.expression1.external.c1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String exp = (String) o[0];
		Map opMap = (Map) o[1];
		
		List list = (List) prepare.t(exp);
		return new F1(list,opMap);
	}
	
	
	
	private class F1 implements F
	{
		private List list;
		private Map opMap;
		
		public F1(List list, Map opMap)
		{
			this.list = list;
			this.opMap = opMap;
		}
		
		public boolean f(Object obj) throws Exception
		{
			T external = buildExternal(obj,opMap);
			T t = (T) resolver1.t(external);
			Boolean r = (Boolean) t.t(list);
			return r.booleanValue();
		}
	}
	
	
	private T buildExternal(Object obj, Map opMap) throws Exception
	{return (T) buildExternal.t(new Object[]{obj,opMap});}
}
