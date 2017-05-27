package gus06.entity.gus.dirfile.find.depth;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170113";}
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		String path = file.getAbsolutePath();
		int depth = path.split(File.separator).length;
		
		return new Integer(depth);
	}
}
