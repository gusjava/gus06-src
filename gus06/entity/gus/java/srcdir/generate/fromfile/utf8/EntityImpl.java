package gus06.entity.gus.java.srcdir.generate.fromfile.utf8;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170223";}


	private Service readFile;
	private Service generate;


	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string.autodetect");
		generate = Outside.service(this,"gus.java.srcdir.generate.fromsrc.utf8");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file_input = o[0];
		File dir_output = o[1];
		
		String src = (String) readFile.t(file_input);
		generate.p(new Object[]{src,dir_output});
	}
}
