package gus06.entity.gus.data.filter.number.even;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160819";}
	
	
	public boolean f(Object obj) throws Exception
	{
		if(obj==null) return false;
		if(!(obj instanceof Number)) return false;
		
		int v = ((Number) obj).intValue();
		return v%2==0;
	}
	
}
