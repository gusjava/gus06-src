package gus06.entity.gus.dir.listing0.files.names;

import java.io.File;
import java.io.FileFilter;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160408";}

	
	public static final FileFilter FILEFILTER = new FileFilter(){
		public boolean accept(File f) {return f.isFile();}
	};


	public Object t(Object obj) throws Exception
	{
		File dir = (File) obj;
		File[] f = dir.listFiles(FILEFILTER);
		
		String[] n = new String[f.length];
		for(int i=0;i<f.length;i++) n[i] = f[i].getName();
		
		return n;
	}
}
