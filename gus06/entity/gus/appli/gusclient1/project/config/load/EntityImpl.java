package gus06.entity.gus.appli.gusclient1.project.config.load;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, R {

	public String creationDate() {return "20150311";}


	private Service manager;
	private Service idToDir;
	private Service readProp;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusclient1.project.manager");
		idToDir = Outside.service(this,"gus.appli.gusclient1.project.idtodir.resource");
		readProp = Outside.service(this,"gus.file.read.properties");
	}
	
	
	
	public Object r(String key) throws Exception
	{
		String id = (String) manager.g();
		if(id==null) return null;
		
		File dir = (File) idToDir.t(id);
		File file = new File(dir,key);
		if(!file.exists()) throw new Exception("Config file not found: "+file);
		
		return readProp.t(file);
	}
}
