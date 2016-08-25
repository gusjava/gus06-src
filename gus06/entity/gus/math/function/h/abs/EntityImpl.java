package gus06.entity.gus.math.function.h.abs;

import gus06.framework.*;

public class EntityImpl implements Entity, H {

	public String creationDate() {return "20160802";}
	
	public double h(double value) throws Exception
	{return Math.abs(value);}
}
