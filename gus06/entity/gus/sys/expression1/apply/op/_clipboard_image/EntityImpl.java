package gus06.entity.gus.sys.expression1.apply.op._clipboard_image;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.util.Collection;
import java.awt.Image;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160611";}

	public static final String T = "constant";


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.clipboard.access.image");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return perform.g();
	}
}
