package gus06.entity.gus.sys.expression1.builder1.t;

import gus06.framework.*;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151031";}

	private Service prepare;
	private Service resolver1;
	private Service buildExternal;
	private Service buildPools;

	public EntityImpl() throws Exception
	{
		prepare = Outside.service(this,"gus.sys.parser3.prepare");
		resolver1 = Outside.service(this,"gus.sys.parser3.resolver1");
		buildExternal = Outside.service(this,"gus.sys.expression1.external");
		buildPools = Outside.service(this,"gus.sys.expression1.builder1.pools");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String exp = (String) o[0];
		Map opMap = (Map) o[1];
		
		List list = (List) prepare.t(exp);
		return new T1(list,opMap);
	}
	
	
	
	private class T1 implements T
	{
		private List list;
		private Map opMap;
		
		public T1(List list, Map opMap)
		{
			this.list = list;
			this.opMap = opMap;
		}
		
		public Object t(Object obj) throws Exception
		{
			List pools = buildPools(obj);
			T external = buildExternal(pools,opMap);
			
			resolver1.v("external",external);
			return resolver1.t(list);
		}
	}
	
	private List buildPools(Object obj) throws Exception
	{return (List) buildPools.t(obj);}
	
	private T buildExternal(List pools, Map opMap) throws Exception
	{return (T) buildExternal.t(new Object[]{pools,opMap});}
}
