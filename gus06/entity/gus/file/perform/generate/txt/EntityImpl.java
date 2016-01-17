package gus06.entity.gus.file.perform.generate.txt;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150620";}


	private Service fileToText;
	private Service writeText;


	public EntityImpl() throws Exception
	{
		fileToText = Outside.service(this,"gus.file.read.string.generic");
		writeText = Outside.service(this,"gus.file.write.string.autodetect");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String s = (String) fileToText.t(o[0]);
		writeText.p(new Object[]{o[1],s});
	}
}
