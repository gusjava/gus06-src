package gus06.entity.gus.app.jarfile.mainclass.findsrc;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140916";}



	

	private Service findMainclass;
	private Service classpathToSrc;

	
	public EntityImpl() throws Exception
	{
		findMainclass = Outside.service(this,"gus.app.jarfile.mainclass");
		classpathToSrc = Outside.service(this,"gus.app.jarfile.classpath.findsrc");
	}
	
	
	public Object g() throws Exception
	{
		String classpath = (String) findMainclass.g();
		return classpathToSrc.t(classpath);
	}
}
