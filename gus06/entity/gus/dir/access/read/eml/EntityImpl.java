package gus06.entity.gus.dir.access.read.eml;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160609";}
	
	public static final String EXTENSION = "eml";


	private Service readFile;
	
	public EntityImpl() throws Exception
	{readFile = Outside.service(this,"gus.file.read.mail");}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		String key = (String) o[1];
		
		File f = file(dir,key);
		if(!f.exists()) return null;
		return readFile.t(f);
	}
	
	private File file(File dir, String key)
	{
		if(!dir.exists()) dir.mkdirs();
		return new File(dir,key+"."+EXTENSION);
	}
}
