package gus06.entity.gus.tostring.number;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160812";}

	
	
	public Object t(Object obj) throws Exception
	{
		Number num = (Number) obj;
		double d = num.doubleValue();
		int n = num.intValue();
		
		return d==n ? ""+n : ""+d;
	}
}