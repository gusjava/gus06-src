package gus06.entity.gus.file.write.string.cs.utf8;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;
import java.nio.charset.Charset;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150302";}
	
	public static final Charset CHARSET = Charset.forName("UTF-8");
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		String text = (String) o[1];
		
		PrintStream p = new PrintStream(file,CHARSET.name());
		p.print(text);
		p.close();
	}
}
