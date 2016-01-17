package gus06.entity.gus.app.jarfile.manager.gyem.module.findsrc;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140916";}



	

	private Service nameToClasspath;
	private Service classpathToSrc;

	
	public EntityImpl() throws Exception
	{
		nameToClasspath = Outside.service(this,"gus.app.manager.gyem.module.nametoclasspath");
		classpathToSrc = Outside.service(this,"gus.app.jarfile.classpath.findsrc");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return "";
		String classpath = (String) nameToClasspath.t(obj);
		return classpathToSrc.t(classpath);
	}
}
