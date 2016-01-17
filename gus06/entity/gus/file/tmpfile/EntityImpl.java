package gus06.entity.gus.file.tmpfile;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, G, T {

	public String creationDate() {return "20140725";}

	private Service now;
	private File tmpDir;

	public EntityImpl() throws Exception
	{
		now = Outside.service(this,"gus.time.now");
		tmpDir = (File) Outside.resource(this,"defaultdir");
	}
	
	
	public Object g() throws Exception
	{return file(now());}
	
	
	public Object t(Object obj) throws Exception
	{
		String ext = (String) obj;
		return file(now()+"."+ext);
	}
	
	
	private File file(String name) throws Exception
	{
		File file = new File(tmpDir,name);
		file.deleteOnExit();
		return file;
	}
	
	private String now() throws Exception
	{return (String) now.g();}
}
