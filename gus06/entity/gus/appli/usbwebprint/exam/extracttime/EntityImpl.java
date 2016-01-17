package gus06.entity.gus.appli.usbwebprint.exam.extracttime;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140915";}


	private Service lastModified;


	public EntityImpl() throws Exception
	{
		lastModified = Outside.service(this,"gus.file.lastmodified.timestamp");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		File f = (File) obj;
		return lastModified.t(f);
	}
}
