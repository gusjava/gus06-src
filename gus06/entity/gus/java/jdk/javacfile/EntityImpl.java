package gus06.entity.gus.java.jdk.javacfile;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140725";}


	private Service jdkManager;

	public EntityImpl() throws Exception
	{
		jdkManager = Outside.service(this,"gus.java.jdk.manager");
	}
	
	
	public Object g() throws Exception
	{
		File jdkDir = (File) jdkManager.g();
		File javacExe = new File(new File(jdkDir,"bin"),"javac.exe");

		if(!javacExe.isFile()) throw new Exception("Javac exe not found: "+javacExe);
		return javacExe;
	}
}
