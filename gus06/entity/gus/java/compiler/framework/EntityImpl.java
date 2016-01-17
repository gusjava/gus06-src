package gus06.entity.gus.java.compiler.framework;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20141110";}


	private Service compiler;
	private Service readFile;
	private Service extractPackage;
	private Service initFramework;
	

	public EntityImpl() throws Exception
	{
		compiler = Outside.service(this,"gus.java.compiler1");
		readFile = Outside.service(this,"gus.file.read.string");
		extractPackage = Outside.service(this,"gus.java.srccode.extract.package1");
		initFramework = Outside.service(this,"gus.app.jarfile.extract1.framework2");
	}
	
	
	public void e() throws Exception
	{
		initFramework.e();
		compiler.p(new Filter());
	}



	private class Filter implements F
	{
		public boolean f(Object obj) throws Exception
		{
			File file = (File) obj;
			String src = (String) readFile.t(file);
			String package1 = (String) extractPackage.t(src);

			if(package1.equals("gus06.framework")) return true;

			return false;
		}
	}
}
