package gus06.entity.gus.sys.expression1.apply.op._rootdirs;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160711";}

	public static final String T = "constant";

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return File.listRoots();
	}
}
