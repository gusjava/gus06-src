package gus06.entity.gus.appli.gusclient1.project.idtofile.resource.prop;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140905";}


	public static final String FILENAME = "prop";
	
	private Service idToDir;
	
	
	public EntityImpl() throws Exception
	{
		idToDir = Outside.service(this,"gus.appli.gusclient1.project.idtodir.resource");
	}
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		File dir = (File) idToDir.t(obj);
		File file = new File(dir,FILENAME);
		
		file.createNewFile();
		return file;
	}
}
