package gus06.entity.gus.dir.hdd.space.total.formatted.fr;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170102";}


	private Service formatter;


	public EntityImpl() throws Exception
	{
		formatter = Outside.service(this,"gus.file.size.formatter1.fr");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		long size = file.getTotalSpace();
		return formatSize(new Long(size));
	}
	
	
	private String formatSize(Long size) throws Exception
	{return (String) formatter.t(size);}
}
