package gus06.entity.gus.sys.expression1.apply.op._m_mask_n;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160404";}


	private Service buildFilter;

	public EntityImpl() throws Exception
	{buildFilter = Outside.service(this,"gus.filter.string.build.mask_n");}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new F1((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class F1 implements F
	{
		private String data;
		public F1(String data) {this.data = data;}
		
		public boolean f(Object obj) throws Exception
		{
			F f = (F) buildFilter.t(obj);
			return f.f(data);
		}
	}
}
