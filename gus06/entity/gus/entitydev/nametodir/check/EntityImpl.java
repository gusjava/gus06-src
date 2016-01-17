package gus06.entity.gus.entitydev.nametodir.check;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150525";}


	private Service nameToDir;


	public EntityImpl() throws Exception
	{
		nameToDir = Outside.service(this,"gus.entitydev.nametodir");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		File dir = (File) nameToDir.t(obj);
		return dir.isDirectory();
	}
}
