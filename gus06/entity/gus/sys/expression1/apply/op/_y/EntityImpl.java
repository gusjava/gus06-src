package gus06.entity.gus.sys.expression1.apply.op._y;

import gus06.framework.*;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.Point;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170306";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Rectangle) return toY((Rectangle) obj);
		if(obj instanceof Component) return toY((Component) obj);
		if(obj instanceof Point) return toY((Point) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Integer toY(Rectangle rec)
	{return new Integer(rec.y);}
	
	private Integer toY(Component c)
	{return new Integer(c.getY());}
	
	private Integer toY(Point p)
	{return new Integer(p.y);}
}
