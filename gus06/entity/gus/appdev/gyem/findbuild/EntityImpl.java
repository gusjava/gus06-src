package gus06.entity.gus.appdev.gyem.findbuild;

import java.io.File;
import java.util.Properties;
import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140908";}


	private Service readFile;
	private File file;


	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.java.srcfile.extract.gyem.build");
		file = (File) Outside.resource(this,"dev_gyem_version");
	}
	
	
	public Object g() throws Exception
	{return readFile.t(file);}
}
