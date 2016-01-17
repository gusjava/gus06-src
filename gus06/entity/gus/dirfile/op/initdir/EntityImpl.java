package gus06.entity.gus.dirfile.op.initdir;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151114";}

	
	
	public void p(Object obj) throws Exception
	{
		File f = (File) obj;
		
		if(f.isFile()) throw new Exception("Path is already an existing file: "+f);
		if(f.isDirectory()) return;
		
		f.mkdirs();
	}
}
