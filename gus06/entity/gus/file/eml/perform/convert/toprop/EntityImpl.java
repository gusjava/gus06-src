package gus06.entity.gus.file.eml.perform.convert.toprop;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151015";}


	private Service readProp;
	private Service writeProp;
	
	public EntityImpl() throws Exception
	{
		readProp = Outside.service(this,"gus.file.read.properties.from.eml");
		writeProp = Outside.service(this,"gus.file.write.properties");
	}


	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File input = o[0];
		File output = o[1];
		
		Object prop = readProp.t(input);
		writeProp.p(new Object[]{output,prop});
	}
}
