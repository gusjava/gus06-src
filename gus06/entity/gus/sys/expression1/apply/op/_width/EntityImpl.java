package gus06.entity.gus.sys.expression1.apply.op._width;

import gus06.framework.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.awt.Rectangle;
import java.awt.Component;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151129";}


	private Service perform;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.width");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Image) 		return perform.t(obj);
		if(obj instanceof RenderedImage) 	return perform.t(obj);
		if(obj instanceof Rectangle) 		return perform.t(obj);
		if(obj instanceof Dimension) 		return perform.t(obj);
		if(obj instanceof Component) 		return perform.t(obj);
		
		if(obj instanceof double[]) 		return perform.t(obj);
		if(obj instanceof int[]) 		return perform.t(obj);
		if(obj instanceof List) 		return perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
