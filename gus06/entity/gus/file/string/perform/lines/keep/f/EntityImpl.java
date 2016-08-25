package gus06.entity.gus.file.string.perform.lines.keep.f;

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
		F f = (F) o[1];
		
		String[] lines = (String[]) readFile.t(file);
		PrintStream p = (PrintStream) toPrintStream.t(file);
		
		for(String line:lines)
		{
			if(f.f(line))
			p.println(line);
		}
		p.close();
	}
}
