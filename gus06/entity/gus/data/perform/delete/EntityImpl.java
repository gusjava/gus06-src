package gus06.entity.gus.data.perform.delete;

import gus06.framework.*;
import java.io.IOException;
import java.io.Closeable;
import java.io.File;
import java.util.Iterator;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151115";}


	private Service deleteFile;
	
	
	public EntityImpl() throws Exception
	{
		deleteFile = Outside.service(this,"gus.dirfile.op.delete");
	}


	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof File)
		{delete((File) obj);return;}
		
		if(obj instanceof Iterator)
		{delete((Iterator) obj);return;}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private void delete(File f) throws Exception
	{
		deleteFile.p(f);
	}
	
	private void delete(Iterator it)
	{
		it.remove();
	}
}
