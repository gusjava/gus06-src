package gus06.entity.gus.file.lastmodified;

import gus06.framework.*;
import java.io.File;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170302";}
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		return new Date(file.lastModified());
	}
}
