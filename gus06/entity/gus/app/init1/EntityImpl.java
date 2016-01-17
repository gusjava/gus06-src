package gus06.entity.gus.app.init1;

import gus06.framework.*;

public class EntityImpl implements Entity {

	public String creationDate() {return "20150626";}


	private Service initJar;
	private Service initDll;
	private Service modifyPath;
	private Service writePid;


	public EntityImpl() throws Exception
	{
		initJar = Outside.service(this,"gus.app.init.jar");
		initDll = Outside.service(this,"gus.app.init.dll");
		modifyPath = Outside.service(this,"gus.system.javalibrarypath.modify.init");
		writePid = Outside.service(this,"gus.app.init.writepid");
	}
}
