package gus06.entity.gus.dir.children.hasfile;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20140715";}
	
	
	public boolean f(Object obj) throws Exception
	{
		File dir = (File) obj;
		if(!dir.exists()) return false;
		
		if(!dir.isDirectory()) throw new Exception("Dir expected: "+dir);
		
		File[] ff = dir.listFiles();
		if(ff==null) return false;
		for(File f:ff) if(f.isFile()) return true;
		return false;
	}
}
