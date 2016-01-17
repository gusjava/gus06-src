package gus06.entity.gus.app.autoexit;

import java.io.File;
import java.io.PrintStream;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import gus06.framework.*;

public class EntityImpl extends TimerTask implements Entity {

	public String creationDate() {return "20140704";}

	
	public static final long LAPSE = 500;
	
	private PrintStream out;
	private File file;
	
	
	public EntityImpl() throws Exception
	{
		out = (PrintStream) Outside.resource(this,"sysout");
		file = new File("stop");
		new Timer("TIMER_"+getClass().getName()).schedule(this,new Date(),LAPSE);
	}


	public void run()
	{
		if(!file.isFile()) return;
		file.delete();
		
		out.println("stop file detected: exiting application");
		System.exit(0);
	}
}
