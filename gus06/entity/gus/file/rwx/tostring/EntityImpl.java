package gus06.entity.gus.file.rwx.tostring;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150811";}
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		StringBuffer b = new StringBuffer();
		
		if(file.canRead()) b.append("r");
		if(file.canWrite()) b.append("w");
		if(file.canExecute()) b.append("x");
		
		return b.toString();
	}
}
