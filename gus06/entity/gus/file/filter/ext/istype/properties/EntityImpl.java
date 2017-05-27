package gus06.entity.gus.file.filter.ext.istype.properties;

import java.io.File;
import java.io.FileFilter;
import gus06.framework.*;

public class EntityImpl implements Entity, F, G, FileFilter {

	public String creationDate() {return "20161115";}



	public boolean accept(File f)
	{
		if(!f.isFile()) return false;
		String n = f.getName().toLowerCase();
		return n.endsWith(".tiff");
	}
	
	
	public boolean f(Object obj) throws Exception
	{return accept((File)obj);}
	
	
	public Object g() throws Exception
	{return this;}
}