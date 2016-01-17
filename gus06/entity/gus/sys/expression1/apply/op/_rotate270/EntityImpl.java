package gus06.entity.gus.sys.expression1.apply.op._rotate270;

import gus06.framework.*;
import java.awt.image.RenderedImage;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151115";}


	private Service perform;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.awt.renderedimage.transform.rotate270");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof RenderedImage) return perform.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
