package gus06.entity.gus.sys.expression1.apply.op._searchfiles_filtername;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151202";}


	private Service builder;
	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.sys.expression1.builder1.f");
		perform = Outside.service(this,"gus.dir.perform.searchfiles.filtername");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof File) return new T1(value,opMap);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private Object value;
		private Map opMap;
		
		public T1(Object value, Map opMap)
		{
			this.value = value;
			this.opMap = opMap;
		}
		
		public Object t(Object obj) throws Exception
		{
			F f = (F) builder.t(new Object[]{obj,opMap});
			return perform.t(new Object[]{value,f});
		}
	}
}
