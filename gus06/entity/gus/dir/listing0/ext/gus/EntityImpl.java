package gus06.entity.gus.dir.listing0.ext.gus;

import java.io.File;
import java.io.FileFilter;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170401";}

	
	public static final String FILEEXTENSION = "gus";
	
	public static final FileFilter FILEFILTER = new FileFilter(){
		public boolean accept(File f)
		{return f.isFile() && f.getName().endsWith("."+FILEEXTENSION);}
	};


	public Object t(Object obj) throws Exception
	{
		File dir = (File) obj;
		return dir.listFiles(FILEFILTER);
	}
}
