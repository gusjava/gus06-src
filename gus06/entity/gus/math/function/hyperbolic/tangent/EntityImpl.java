package gus06.entity.gus.math.function.hyperbolic.tangent;

import gus06.framework.*;

public class EntityImpl implements Entity, H {

	public String creationDate() {return "20150309";}
	
	public double h(double value) throws Exception
	{return (e(value)-e(-value)) / (e(value)+e(-value));}
	
	private double e(double v)
	{return Math.exp(v);}
}
