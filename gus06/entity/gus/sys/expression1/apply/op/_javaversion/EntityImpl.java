package gus06.entity.gus.sys.expression1.apply.op._javaversion;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170411";}

	public static final String T = "constant";
	

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return System.getProperty("java.version");
	}
}
