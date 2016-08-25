package gus06.entity.gus.file.write.string.append.cs.default0;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;
import java.io.FileOutputStream;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160415";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		String text = (String) o[1];
		
		FileOutputStream fos = new FileOutputStream(file,true);
		PrintStream p = new PrintStream(fos,true);
		p.print(text);
		p.close();
	}
}
