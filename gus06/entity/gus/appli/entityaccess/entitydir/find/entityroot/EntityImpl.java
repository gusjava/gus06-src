package gus06.entity.gus.appli.entityaccess.entitydir.find.entityroot;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150304";}

	public static final String KEY_ENTITYDIR = "entitydir";
	
	private Service getFile;
	
	public EntityImpl() throws Exception
	{
		getFile = Outside.service(this,"gus.sys.option.getfile");
	}
	
	public Object g() throws Exception
	{
		File d0 = (File) getFile.r(KEY_ENTITYDIR);
		if(d0==null) return null;
		
		File d1 = new File(d0,"gus06");
		return new File(d1,"entity");
	}
}
