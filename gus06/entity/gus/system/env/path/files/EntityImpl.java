package gus06.entity.gus.system.env.path.files;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20170312";}

	
	
	public Object g() throws Exception
	{
		String value = System.getenv("Path");
		String[] nn = value.split(";");
		
		File[] ff = new File[nn.length];
		for(int i=0;i<nn.length;i++)
		ff[i] = new File(nn[i]);
		
		return ff;
	}
}
