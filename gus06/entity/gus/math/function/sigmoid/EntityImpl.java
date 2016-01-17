package gus06.entity.gus.math.function.sigmoid;

import gus06.framework.*;

public class EntityImpl implements Entity, H {

	public String creationDate() {return "20150309";}
	
	public double h(double value) throws Exception
	{return 1 / (1 + Math.exp(-value));}
}
