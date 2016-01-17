package gus06.entity.gus.sys.expression1.apply.op._even;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151109";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer)
		{
			int n = ((Integer)obj).intValue();
			return new Boolean(check(n));
		}
		if(obj instanceof Double)
		{
			Double d = (Double) obj;
			if(!isInt(d)) return Boolean.FALSE;
			return new Boolean(check(d.intValue()));
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private boolean check(int n)
	{return n%2==0;}
	
	
	private boolean isInt(Double d)
	{return d.intValue()==d.doubleValue();}
}