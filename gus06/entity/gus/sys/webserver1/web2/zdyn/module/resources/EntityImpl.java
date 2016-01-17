package gus06.entity.gus.sys.webserver1.web2.zdyn.module.resources;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, R {

	public String creationDate() {return "20140930";}

	public static final String RESOURCE = "resource";
	public static final String S = File.separator;

	private Service pathToFile;

	public EntityImpl() throws Exception
	{pathToFile = Outside.service(this,"gus.sys.webserver1.web2.zdyn.module.pathtofile");}
	
	
	public Object r(String key) throws Exception
	{
		File file = (File) pathToFile.t(key);
		if(!file.getAbsolutePath().contains(S+RESOURCE+S)) return null;
		if(!file.isFile()) return null;
		
		return file;
	}
}
