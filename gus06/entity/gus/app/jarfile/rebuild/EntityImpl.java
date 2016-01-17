package gus06.entity.gus.app.jarfile.rebuild;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140716";}


	private Service jarBuilder;
	private Service findMain;
	private Service appJar;
	

	public EntityImpl() throws Exception
	{
		jarBuilder = Outside.service(this,"gus.file.jar.builder1");
		findMain = Outside.service(this,"gus.app.jarfile.mainclass");
		appJar = Outside.service(this,"gus.app.jarfile");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		File out = (File) appJar.g();
		String mainClass = (String) findMain.g();
		
		jarBuilder.v("bin",obj);
		jarBuilder.v("jarFile",out);
		jarBuilder.v("mainClass",mainClass);
		
		jarBuilder.e();
	}
}
