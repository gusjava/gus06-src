package gus06.entity.gus.math.function.h.cuberoot;

import gus06.framework.*;

public class EntityImpl implements Entity, H {

	public String creationDate() {return "20160722";}
	
	public double h(double value) throws Exception
	{return Math.cbrt(value);}
}
