package gus06.entity.gus.data.compare.o1;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20161215";}
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return equals(o[0],o[1]);
	}
	
	private boolean equals(Object o1, Object o2)
	{
		if(o1==null && o2==null) return true;
		if(o1==null || o2==null) return false;
		
		if(o1 instanceof Number && o2 instanceof Number)
		{
			double d1 = ((Number) o1).doubleValue();
			double d2 = ((Number) o2).doubleValue();
			return d1==d2;
		}
		return o1.equals(o2);
	}
}