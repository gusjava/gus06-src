package gus06.entity.gus.file.write.string.autodetect;

import gus06.framework.*;

import java.io.File;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141215";}
	


	private Service findCharset;

	public EntityImpl() throws Exception
	{
		findCharset = Outside.service(this,"gus.file.write.string.autodetect.findcharset");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		String text = (String) o[1];
		Charset charset = charset(file,text);
		
		PrintStream p = new PrintStream(file,charset.name());
		p.print(text);
		p.close();
	}
	
	
	private Charset charset(File file, String text) throws Exception
	{return (Charset) findCharset.t(new Object[]{file,text});}
}
