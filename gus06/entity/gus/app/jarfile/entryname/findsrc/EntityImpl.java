package gus06.entity.gus.app.jarfile.entryname.findsrc;

import gus06.framework.*;
import java.io.File;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140829";}


	private Service findJar;
	private Service isToString;

	
	public EntityImpl() throws Exception
	{
		findJar = Outside.service(this,"gus.app.jarfile");
		isToString = Outside.service(this,"gus.io.transfer.tostring");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return "";
		String entryName = (String) obj;
		
		File file = (File) findJar.g();
		JarFile jarFile = new JarFile(file,true,JarFile.OPEN_READ);
		String src = read(jarFile,entryName);
		jarFile.close();
		
		return src;
	}
	
	
	
	private String read(JarFile jarFile, String entryName) throws Exception
	{
		JarEntry jarEntry = jarFile.getJarEntry(entryName);
		if(jarEntry==null) throw new Exception("Jar entry not found: "+entryName);
		
		InputStream is = jarFile.getInputStream(jarEntry);
		return (String) isToString.t(is);
	}
}
