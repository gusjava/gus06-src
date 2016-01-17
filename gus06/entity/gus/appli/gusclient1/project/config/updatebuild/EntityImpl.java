package gus06.entity.gus.appli.gusclient1.project.config.updatebuild;

import java.io.File;
import java.util.Properties;
import gus06.framework.*;

public class EntityImpl implements Entity, E, P {

	public String creationDate() {return "20140907";}

	public static final String KEY_VERSION = "app.version";	
	
	private Service manager;
	private Service idToFile;
	private Service buildProp;
	private Service writeProp;
	

	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusclient1.project.manager");
		idToFile = Outside.service(this,"gus.appli.gusclient1.project.idtofile.resource.p_build");
		buildProp = Outside.service(this,"gus.appdev.updatebuild.buildprop");
		writeProp = Outside.service(this,"gus.file.write.properties.merge.replace");
	}
	
	
	public void e() throws Exception
	{
		String id = (String) manager.g();
		if(id==null) return;
		
		File file = (File) idToFile.t(id);
		Properties p = (Properties) buildProp.g();
		writeProp.p(new Object[]{file,p});
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		String version = (String) obj;
		
		String id = (String) manager.g();
		if(id==null) return;
		
		File file = (File) idToFile.t(id);
		Properties p = (Properties) buildProp.g();
		if(version!=null) p.put(KEY_VERSION,version);
		writeProp.p(new Object[]{file,p});
	}
}
