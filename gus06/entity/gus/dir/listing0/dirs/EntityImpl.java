package gus06.entity.gus.dir.listing0.dirs;

import java.io.File;
import java.io.FileFilter;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150823";}

	
	public static final FileFilter DIRFILTER = new FileFilter(){
		public boolean accept(File f) {return f.isDirectory();}
	};


	public Object t(Object obj) throws Exception
	{
		File dir = (File) obj;
		return dir.listFiles(DIRFILTER);
	}
}
