package gus06.entity.gus.file.write.string.autodetect;

import gus06.framework.*;

import java.io.File;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141215";}
	
	public static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");


	private Service hasUnicode;
	private Service findCharset;
	private Service forceUTF8;


	public EntityImpl() throws Exception
	{
		hasUnicode = Outside.service(this,"gus.filter.string.haschar.unicode");
		findCharset = Outside.service(this,"gus.file.string.info.charset");
		forceUTF8 = Outside.service(this,"gus.file.write.string.autodetect.forceutf8");
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
	{
		if(forceUTF8.f(file)) return CHARSET_UTF8;
		if(hasUnicode.f(text)) return CHARSET_UTF8;
		
		Charset charset = (Charset) findCharset.t(file);
		return charset!=null?charset:Charset.defaultCharset();
	}
}
