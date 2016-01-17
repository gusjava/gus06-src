package gus06.entity.gus.file.getname;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141021";}

	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		return file.getName();
	}
}
