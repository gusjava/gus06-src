package gus06.entity.gus.math.function.h.cube;

import gus06.framework.*;

public class EntityImpl implements Entity, H {

	public String creationDate() {return "20160802";}
	
	public double h(double value) throws Exception
	{return value*value*value;}
}
