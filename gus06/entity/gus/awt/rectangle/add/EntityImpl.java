package gus06.entity.gus.awt.rectangle.add;

import gus06.framework.*;
import java.awt.Rectangle;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170306";}

	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Rectangle r = (Rectangle) o[0];
		Object value = o[1];
		
		if(value instanceof Integer)
		{
			int dep = ((Integer) value).intValue();
			r.setLocation(r.x+dep,r.y+dep);
			return;
		}
		if(value instanceof int[])
		{
			int[] dep = (int[]) value;
			r.setLocation(r.x+dep[0],r.y+dep[1]);
			return;
		}
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
}
