package gus06.entity.gus.file.string.perform.apply.t;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150928";}


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
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		T t = (T) o[1];
		
		String text = (String) readFile.t(file);
		text = (String) t.t(text);
		writeFile.p(new Object[]{file,text});
	}
}
