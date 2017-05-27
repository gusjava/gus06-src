package gus06.entity.gus.sys.expression1.apply.op._height;

import gus06.framework.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.RenderedImage;
import java.awt.Image;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151129";}


	private Service perform;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.height");
	}



	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj instanceof Image) 		return perform.t(obj);
		if(obj instanceof RenderedImage) 	return perform.t(obj);
		if(obj instanceof Rectangle) 		return perform.t(obj);
		if(obj instanceof Dimension) 		return perform.t(obj);
		if(obj instanceof Component) 		return perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
