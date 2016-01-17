package gus06.entity.gus.appli.gusclient1.project.config.set.p_path;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20150615";}


	private Service manager;
	private Service idToFile;
	private Service modify;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusclient1.project.manager");
		idToFile = Outside.service(this,"gus.appli.gusclient1.project.idtofile.resource.p_path");
		modify = Outside.service(this,"gus.file.modify.properties.keyvalue");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		String id = (String) manager.g();
		if(id==null) return;
		
		File propFile = (File) idToFile.t(id);
		modify.p(new Object[]{propFile,key,obj});
	}
}
