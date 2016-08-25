package gus06.entity.gus.file.string.perform.lines.apply.t;

import java.io.File;
import gus06.framework.*;
import java.io.PrintStream;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160412";}


	private Service readFile;
	private Service toPrintStream;
	
	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string.array.autodetect");
		toPrintStream = Outside.service(this,"gus.io.printstream.autodetect");
	}



	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		T t = (T) o[1];
		
		String[] lines = (String[]) readFile.t(file);
		PrintStream p = (PrintStream) toPrintStream.t(file);
		
		for(String line:lines)
		{
			String line1 = (String) t.t(line);
			p.println(line1);
		}
		p.close();
	}
}
