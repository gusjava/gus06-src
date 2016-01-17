package gus06.entity.gus.java.fromclass.javasrc.srczip;

import gus06.framework.*;
import java.io.File;
import java.io.InputStream;
import java.util.zip.*;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140820";}


	private Service inToString;
	private Service findSrcZip;

	public EntityImpl() throws Exception
	{
		inToString = Outside.service(this,"gus.io.transfer.tostring");
		findSrcZip = Outside.service(this,"gus.java.home.srczip");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Class c = (Class) obj;
		
		File file = (File) findSrcZip.g();
		if(file==null) return null;
		
		ZipFile zipFile = null;
		String src = null;
		
		try
		{
			zipFile = new ZipFile(file,ZipFile.OPEN_READ);
			src = extract(zipFile,c);
		}
		finally	{if(zipFile!=null) zipFile.close();}
		return src;
	}
	
	
	
	
	
	private String extract(ZipFile zipFile, Class c) throws Exception
	{
		String name = c.getName().replace(".","/")+".java";
		
		ZipEntry entry = zipFile.getEntry(name);
		if(entry==null) return null;
		
		InputStream is = zipFile.getInputStream(entry);
		if(is==null) return null;
		
		return (String) inToString.t(is);
	}
}
