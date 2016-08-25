package gus06.entity.gus.sys.expression1.apply.op._math_e;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160613";}

	public static final String T = "constant";
	
	
	public Object t(Object obj) throws Exception
	{
		return new Double(Math.E);
	}
}