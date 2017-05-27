package gus06.entity.gus.sys.expression1.apply.op._x;

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
		
		if(obj instanceof Rectangle) return toX((Rectangle) obj);
		if(obj instanceof Component) return toX((Component) obj);
		if(obj instanceof Point) return toX((Point) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Integer toX(Rectangle rec)
	{return new Integer(rec.x);}
	
	private Integer toX(Component c)
	{return new Integer(c.getX());}
	
	private Integer toX(Point p)
	{return new Integer(p.x);}
}
