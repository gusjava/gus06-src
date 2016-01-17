package gus06.entity.gus.sys.runtask1.input.file;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150602";}


	private Service taskChooser;
	private Service manager;


	public EntityImpl() throws Exception
	{
		taskChooser = Outside.service(this,"gus.sys.runtask1.input.file.chooser");
		manager = Outside.service(this,"gus.sys.runtask1.manager");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File dir = (File) obj;
		if(!dir.isFile()) return;
		
		P task = (P) taskChooser.g();
		if(task==null) return;
		
		manager.v(dir.getAbsolutePath(),task);
	}
}
