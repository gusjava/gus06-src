package gus06.entity.gus.appli.gusclient1.project.idtodir.resource.store;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140907";}


	public static final String DIRNAME = "store";
	
	private Service idToDir;
	
	
	public EntityImpl() throws Exception
	{
		idToDir = Outside.service(this,"gus.appli.gusclient1.project.idtodir.resource");
	}
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		File dir0 = (File) idToDir.t(obj);
		File dir1 = new File(dir0,DIRNAME);
		
		dir1.mkdirs();
		return dir1;
	}
}
