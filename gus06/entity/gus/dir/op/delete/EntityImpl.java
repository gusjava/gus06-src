package gus06.entity.gus.dir.op.delete;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150606";}


	private Service empty;


	public EntityImpl() throws Exception
	{empty = Outside.service(this,"gus.dir.op.empty");}
	
	
	public void p(Object obj) throws Exception
	{
		File dir = (File) obj;
		if(!dir.exists()) return;
		
		if(!dir.isDirectory())
			throw new Exception("Invalid directory: "+dir);
		
		empty.p(dir);
		delete(dir);
	}
	
	
	
	
	private void delete(File dir) throws Exception
	{
		boolean r = dir.delete();
		if(!r) throw new Exception("Failed to delete directory: "+dir);
	}
}
