package gus06.entity.gus.appli.convertisseurgus05.option.dirgus06;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150525";}
	
	public static final String KEY = "dirgus06";
	
	private Service getFile;
	
	public EntityImpl() throws Exception
	{getFile = Outside.service(this,"gus.sys.option.getfile");}
	
	public Object g() throws Exception
	{return getFile.r(KEY);}
}
