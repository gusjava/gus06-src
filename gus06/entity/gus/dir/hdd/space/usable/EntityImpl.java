package gus06.entity.gus.dir.hdd.space.usable;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170102";}

	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		long size = file.getUsableSpace();
		return new Long(size);
	}
}
