package gus06.entity.gus.sys.expression1.apply.op._onlyone;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160804";}


	private Service buildFilter;
	
	public EntityImpl() throws Exception
	{
		buildFilter = Outside.service(this,"gus.filter.array.build.onlyone");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer) 	return onlyOne((Integer) obj);
		if(obj instanceof boolean[])	return onlyOne((boolean[]) obj);
		if(obj instanceof F[])		return buildFilter.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Boolean onlyOne(Integer n)
	{
		return new Boolean(n.intValue()==1);
	}
	
	
	private Boolean onlyOne(boolean[] array)
	{
		int found = 0;
		for(boolean n:array) if(n)
		{
			found++;
			if(found>1) return Boolean.FALSE;
		}
		return new Boolean(found==1);
	}
}
