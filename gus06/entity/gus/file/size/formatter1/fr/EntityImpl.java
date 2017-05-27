package gus06.entity.gus.file.size.formatter1.fr;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170102";}


	private Service format;

	public EntityImpl() throws Exception
	{
		format = Outside.service(this,"gus.string.transform.format.datasize.fr");
	}
	

	public Object t(Object obj) throws Exception
	{
		Long size = toLong(obj);
		return format.t(size);
	}
	
	private Long toLong(Object obj) throws Exception
	{
		if(obj instanceof Long) return (Long) obj;
		if(obj instanceof Integer) return new Long(((Integer) obj).longValue());
		if(obj instanceof String) return new Long((String) obj);
		if(obj instanceof File) return new Long(((File) obj).length());
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
