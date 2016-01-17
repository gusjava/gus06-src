package gus06.entity.gus.appdev.updatebuild;

import java.io.File;
import java.util.Properties;
import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140705";}


	private Service buildProp;
	private Service writeProp;

	private File file;


	public EntityImpl() throws Exception
	{
		buildProp = Outside.service(this,"gus.appdev.updatebuild.buildprop");
		writeProp = Outside.service(this,"gus.file.write.properties.merge.replace");
		file = (File) Outside.resource(this,"dev_p_build");
	}
	
	
	public void e() throws Exception
	{
		Properties p = (Properties) buildProp.g();
		writeProp.p(new Object[]{file,p});
	}
}
