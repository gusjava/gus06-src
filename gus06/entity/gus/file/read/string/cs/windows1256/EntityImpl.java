package gus06.entity.gus.file.read.string.cs.windows1256;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160310";}
	
	public static final Charset CHARSET = Charset.forName("windows-1256");
	

	public Object t(Object obj) throws Exception
	{
		File f = (File) obj;
		if(f==null || !f.isFile()) return null;
		
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis,CHARSET);
		char[] a= new char[(int)f.length()];
		isr.read(a,0,(int) f.length());
		isr.close();
		
		return new String(a);
	}
}
