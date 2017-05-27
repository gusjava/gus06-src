package gus06.entity.gus.dir.access.getfile.properties.randomid;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150826";}
	
	public static final String EXTENSION = "properties";


	private Service randomId;

	public EntityImpl() throws Exception
	{
		randomId = Outside.service(this,"gus.data.generate.string.random.number14");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		File dir = (File) obj;
		if(!dir.exists()) dir.mkdirs();
		String name = (String) randomId.g();
		return new File(dir,name+"."+EXTENSION);
	}
}
