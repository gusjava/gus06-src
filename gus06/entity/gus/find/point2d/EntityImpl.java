package gus06.entity.gus.find.point2d;

import gus06.framework.*;
import java.awt.geom.Point2D;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170425";}

	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		if(obj instanceof Point2D) return obj;
		if(obj instanceof double[]) return fromDoubleArray((double[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Point2D fromDoubleArray(double[] v)
	{return new Point2D.Double(v[0],v[1]);}
}
