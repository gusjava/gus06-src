package gus06.entity.gus.exception.uncaughtexceptionhandler.init;

import gus06.framework.*;
import java.lang.Thread.UncaughtExceptionHandler;

public class EntityImpl implements Entity, UncaughtExceptionHandler {

	public String creationDate() {return "20140916";}


	public EntityImpl() throws Exception
	{Thread.setDefaultUncaughtExceptionHandler(this);}
	
	
	
	public void uncaughtException(Thread t, Throwable e)
	{
		String message = "Uncaught exception happend in thread: "+t.getName();
		Outside.err(this,"uncaughtException(Thread,Throwable)",new Exception(message,e));
	}
}
