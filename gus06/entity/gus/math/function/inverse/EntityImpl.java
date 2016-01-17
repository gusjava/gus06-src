package gus06.entity.gus.math.function.inverse;

import gus06.framework.*;

public class EntityImpl implements Entity, H {

	public String creationDate() {return "20151209";}
	
	public double h(double value) throws Exception
	{return 1 / value;}
}
