package gus06.entity.gus.file.perform.generate.properties;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151018";}


	private Service fileToProp;
	private Service writeProp;


	public EntityImpl() throws Exception
	{
		fileToProp = Outside.service(this,"gus.file.read.properties.generic");
		writeProp = Outside.service(this,"gus.file.write.properties");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map m = (Map) fileToProp.t(o[0]);
		writeProp.p(new Object[]{o[1],m});
	}
}
