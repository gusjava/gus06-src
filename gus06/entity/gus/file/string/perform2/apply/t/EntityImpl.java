package gus06.entity.gus.file.string.perform2.apply.t;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151014";}


	private Service readFile;
	private Service writeFile;
	
	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string.autodetect");
		writeFile = Outside.service(this,"gus.file.write.string.autodetect");
	}


	

	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File input = (File) o[0];
		File output = (File) o[1];
		T t = (T) o[2];
		
		String text = (String) readFile.t(input);
		text = (String) t.t(text);
		writeFile.p(new Object[]{output,text});
	}
}
