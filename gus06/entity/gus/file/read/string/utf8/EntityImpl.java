package gus06.entity.gus.file.read.string.utf8;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import gus06.framework.*;
import java.nio.charset.Charset;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150727";}
	
	
	private Charset charset = Charset.forName("UTF-8");
	

	public Object t(Object obj) throws Exception
	{
		File f = (File) obj;
		if(f==null || !f.isFile()) return null;
		
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis,charset);
		char[] a= new char[(int)f.length()];
		isr.read(a,0,(int) f.length());
		isr.close();
		
		return new String(a);
	}
}
