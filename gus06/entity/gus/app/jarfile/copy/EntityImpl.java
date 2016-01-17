package gus06.entity.gus.app.jarfile.copy;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140721";}


	private Service copy;
	private Service appJar;

	public EntityImpl() throws Exception
	{
		copy = Outside.service(this,"gus.file.op.copy");
		appJar = Outside.service(this,"gus.app.jarfile");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File out = (File) obj;
		File in = (File) appJar.g();
		
		copy.p(new File[]{in,out});
	}
}
