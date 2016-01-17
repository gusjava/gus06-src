package gus06.entity.gus.java.compiler.entity;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140725";}


	private Service compiler;
	private Service readFile;
	private Service extractPackage;
	private Service removeClass;
	private Service initFramework;
	

	public EntityImpl() throws Exception
	{
		compiler = Outside.service(this,"gus.java.compiler1");
		readFile = Outside.service(this,"gus.file.read.string");
		extractPackage = Outside.service(this,"gus.java.srccode.extract.package1");
		removeClass = Outside.service(this,"gus.entitydev.refactor.bin.remove1");
		initFramework = Outside.service(this,"gus.app.jarfile.extract1.framework2");
	}
	
	
	public void p(Object obj) throws Exception
	{
		String name = (String) obj;
	
		initFramework.e();
		removeClass.p(name);
		compiler.p(new Filter(name));
	}



	private class Filter implements F
	{
		private String name;

		public Filter(String name)
		{this.name = name;}

		public boolean f(Object obj) throws Exception
		{
			File file = (File) obj;
			String src = (String) readFile.t(file);
			String package1 = (String) extractPackage.t(src);

			if(package1.equals("gus06.framework")) return true;
			if(package1.equals("gus06.entity."+name)) return true;

			return false;
		}
	}
}
