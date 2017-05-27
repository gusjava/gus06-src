package gus06.entity.gus.dir.total.filesize;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161116";}


	public Object t(Object obj) throws Exception
	{
		return new Long(handle((File) obj));
	}
	
	private long handle(File file)
	{
		if(!file.exists()) return 0;
		if(file.isFile()) return file.length();
		
		long size = 0;
		File[] ff = file.listFiles();
		if(ff!=null) for(File f:ff) size += handle(f);
		return size;
	}
}
