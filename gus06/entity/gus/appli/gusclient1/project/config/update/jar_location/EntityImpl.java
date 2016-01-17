package gus06.entity.gus.appli.gusclient1.project.config.update.jar_location;

import java.io.File;
import java.util.Properties;
import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150615";}

	
	private Service manager;
	private Service idToFile;
	private Service idToDir;
	private Service writeProp;
	

	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusclient1.project.manager");
		idToFile = Outside.service(this,"gus.appli.gusclient1.project.idtofile.resource.jar_location");
		idToDir = Outside.service(this,"gus.appli.gusclient1.project.idtodir.resource.jar");
		writeProp = Outside.service(this,"gus.file.write.properties");
	}
	
	
	public void e() throws Exception
	{
		String id = (String) manager.g();
		if(id==null) return;
		
		File file = (File) idToFile.t(id);
		File dir = (File) idToDir.t(id);
		
		File[] ff = dir.listFiles();
		Properties p = new Properties();
		if(ff!=null) for(File f:ff)
		{
			String name = f.getName();
			if(!name.endsWith(".jar")) throw new Exception("Invalid jar file name: "+f);
			
			p.put(name,"jar/"+name);
		}
		writeProp.p(new Object[]{file,p});
	}
}
