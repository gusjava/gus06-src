package gus06.entity.gus.dir.total.filecount;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161117";}


	public Object t(Object obj) throws Exception
	{
		return new Integer(handle((File) obj));
	}
	
	private int handle(File file)
	{
		if(!file.exists()) return 0;
		if(file.isFile()) return 1;
		
		int count = 0;
		File[] ff = file.listFiles();
		if(ff!=null) for(File f:ff) count += handle(f);
		return count;
	}
}
