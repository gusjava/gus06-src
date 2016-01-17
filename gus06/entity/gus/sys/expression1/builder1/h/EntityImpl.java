package gus06.entity.gus.sys.expression1.builder1.h;

import gus06.framework.*;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151112";}

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
		return new H1(list,opMap);
	}
	
	
	
	private class H1 implements H
	{
		private List list;
		private Map opMap;
		
		public H1(List list, Map opMap)
		{
			this.list = list;
			this.opMap = opMap;
		}
		
		public double h(double value) throws Exception
		{
			List pools = buildPools(new Double(value));
			T external = buildExternal(pools,opMap);
			
			resolver1.v("external",external);
			Double r = (Double) resolver1.t(list);
			return r.doubleValue();
		}
	}
	
	private List buildPools(Object obj) throws Exception
	{return (List) buildPools.t(obj);}
	
	private T buildExternal(List pools, Map opMap) throws Exception
	{return (T) buildExternal.t(new Object[]{pools,opMap});}
}
