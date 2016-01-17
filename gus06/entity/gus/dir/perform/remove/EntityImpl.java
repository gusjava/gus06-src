package gus06.entity.gus.dir.perform.remove;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P, F {

	public String creationDate() {return "20140910";}


	private Service empty;


	public EntityImpl() throws Exception
	{empty = Outside.service(this,"gus.dir.perform.empty");}
	
	
	public void p(Object obj) throws Exception
	{f(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{
		File dir = (File) obj;
		if(!dir.isDirectory())
			throw new Exception("Invalid directory: "+dir);
		
		empty.p(dir);
		delete(dir);
		return true;
	}
	
	
	
	
	private void delete(File dir) throws Exception
	{
		boolean r = dir.delete();
		if(!r) throw new Exception("Failed to delete directory: "+dir);
	}
}
