package gus06.entity.gus.dir.listing0.ext.image;

import java.io.File;
import java.io.FileFilter;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150630";}


	private Service provider;
	private FileFilter fileFilter;

	
	public EntityImpl() throws Exception
	{
		provider = Outside.service(this,"gus.file.filter.ext.istype.image");
		fileFilter = (FileFilter) provider.g();
	}



	public Object t(Object obj) throws Exception
	{
		File dir = (File) obj;
		return dir.listFiles(fileFilter);
	}
}
