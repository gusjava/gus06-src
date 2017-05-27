package gus06.entity.gus.url.build.tmpfile;

import gus06.framework.*;
import java.net.URL;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170202";}


	private Service normalizeFileName;
	private Service now;
	
	private File storeDir;
	
	public EntityImpl() throws Exception
	{
		normalizeFileName = Outside.service(this,"gus.string.transform.normalize.filename");
		now = Outside.service(this,"gus.time.now");
		
		storeDir = (File) Outside.resource(this,"defaultdir");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		URL url = (URL) obj;
		
		String fileName = normalizeName(url.getFile());
		
		File dir = new File(storeDir,now());
		dir.mkdirs();
		
		File file = new File(dir,fileName);
		file.createNewFile();
		
		return file;
	}
	
	private String normalizeName(String name) throws Exception
	{return (String) normalizeFileName.t(name);}
	
	private String now() throws Exception
	{return (String) now.g();}
}
