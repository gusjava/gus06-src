package gus06.entity.gus.java.srcdir.generate.fromsrc;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160410";}


	private Service findClassPath;
	private Service findFile;


	public EntityImpl() throws Exception
	{
		findClassPath = Outside.service(this,"gus.java.srccode.extract.classpath");
		findFile = Outside.service(this,"gus.java.srcdir.retrieve.javafile");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		String src = (String) o[1];
		
		String classPath = (String) findClassPath.t(src);
		if(invalid(classPath)) throw new Exception("Invalid java classpath: "+classPath);
		
		File file = (File) findFile.t(new Object[]{dir,classPath});
		file.getParentFile().mkdirs();
		
		PrintStream p = new PrintStream(file);
		p.print(src);
		p.close();
	}
	
	
	private boolean invalid(String s)
	{return s.contains("\n") || s.contains("\t") || s.contains(" ");}
}
