package gus06.entity.gus.file.write.string;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140912";}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		String text = (String) o[1];
		
		PrintStream p = new PrintStream(file);
		p.print(text);
		p.close();
	}
}
