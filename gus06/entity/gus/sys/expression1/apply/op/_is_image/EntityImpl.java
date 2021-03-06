package gus06.entity.gus.sys.expression1.apply.op._is_image;

import gus06.framework.*;
import java.awt.Image;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160804";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return Boolean.FALSE;
		return new Boolean(obj instanceof Image);
	}
}
