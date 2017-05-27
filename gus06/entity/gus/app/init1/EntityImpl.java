package gus06.entity.gus.app.init1;

import gus06.framework.*;

public class EntityImpl implements Entity {

	public String creationDate() {return "20150626";}


	private Service writePid;
	private Service initSysprop;
	private Service initJar;
	private Service initDll;
	private Service initLog;
	private Service modifyPath;
	private Service exceptionHandler;
	private Service initDebugGui;


	public EntityImpl() throws Exception
	{
		writePid = Outside.service(this,"gus.app.init.writepid");
		initSysprop = Outside.service(this,"gus.system.prop.init");
		initJar = Outside.service(this,"gus.app.init.jar");
		initDll = Outside.service(this,"gus.app.init.dll");
		initLog = Outside.service(this,"gus.app.init.log");
		modifyPath = Outside.service(this,"gus.system.javalibrarypath.modify.init");
		exceptionHandler = Outside.service(this,"gus.exception.uncaughtexceptionhandler.init");
		initDebugGui = Outside.service(this,"gus.debug.init.displaygui");
	}
}
