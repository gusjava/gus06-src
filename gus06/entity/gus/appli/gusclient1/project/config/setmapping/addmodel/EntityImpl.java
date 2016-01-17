package gus06.entity.gus.appli.gusclient1.project.config.setmapping.addmodel;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141028";}
	
	public static final String KEY = "model";


	private Service manager;
	private Service idToFile;
	private Service modify;


	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusclient1.project.manager");
		idToFile = Outside.service(this,"gus.appli.gusclient1.project.idtofile.resource.mapping");
		modify = Outside.service(this,"gus.file.modify.properties.keyvalue.seq1");
	}
	
	
	public void p(Object obj) throws Exception
	{
		String id = (String) manager.g();
		if(id==null) return;
		
		File mappingFile = (File) idToFile.t(id);
		modify.p(new Object[]{mappingFile,KEY,obj});
	}
}
