package gus06.entity.gus.dir.hdd.description.build;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140910";}


	private Service driverName;
	private Service formatSize;


	public EntityImpl() throws Exception
	{
		driverName = Outside.service(this,"gus.dir.hdd.drivername");
		formatSize = Outside.service(this,"gus.dir.hdd.space.total.formatted.en");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		File f = (File) obj;
		
		String name = (String) driverName.t(f);
		String size = (String) formatSize.t(f);
		
		return name+" ("+size+")";
	}
}
