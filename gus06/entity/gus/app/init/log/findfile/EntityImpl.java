package gus06.entity.gus.app.init.log.findfile;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20141023";}


	private Service getNow;

	private File dir;
	private File file;
	

	public EntityImpl() throws Exception
	{
		getNow = Outside.service(this,"gus.time.now");
		dir = (File) Outside.resource(this,"path#path.logdir");
	}
	
	public Object g() throws Exception
	{
		if(file==null) init();
		return file;
	}
	
	private void init() throws Exception
	{
		String now = (String) getNow.g();
		String fileName = "log_"+now+".txt";
		file = new File(dir,fileName);
		dir.mkdirs();
	}
}
