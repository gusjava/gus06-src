package gus06.entity.gus.sys.expression1.apply.op._jdkdirs;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161108";}

	public static final String T = "constant";


	private Service jdkDirs;

	public EntityImpl() throws Exception
	{
		jdkDirs = Outside.service(this,"gus.java.jdk.dirs");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return jdkDirs.g();
	}
}
