package gus06.entity.gus.math.function.h.decrement;

import gus06.framework.*;

public class EntityImpl implements Entity, H {

	public String creationDate() {return "20160809";}
	
	public double h(double value) throws Exception
	{return value-1;}
}
