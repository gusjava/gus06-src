package gus06.entity.gus.math.function.trigo.cosine;

import gus06.framework.*;

public class EntityImpl implements Entity, H {

	public String creationDate() {return "20150309";}
	
	public double h(double value) throws Exception
	{return Math.cos(value);}
}
