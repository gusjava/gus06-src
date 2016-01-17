package gus06.entity.gus.app.jarfile.manager.gyem.main.findsrc;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140917";}



	private Service classpathToSrc;

	
	public EntityImpl() throws Exception
	{
		classpathToSrc = Outside.service(this,"gus.app.jarfile.classpath.findsrc");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return "";
		String classpath = "gus06.manager.gus.gyem."+obj;
		return classpathToSrc.t(classpath);
	}
}
