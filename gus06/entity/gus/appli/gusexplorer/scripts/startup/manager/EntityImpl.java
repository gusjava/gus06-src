package gus06.entity.gus.appli.gusexplorer.scripts.startup.manager;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;

public class EntityImpl implements Entity, R, Runnable {

	public String creationDate() {return "20160918";}


	private Service executor0;
	private Service executor1;
	
	private PrintStream out;
	private File dir;
	private Thread t;
	
	
	public EntityImpl() throws Exception
	{
		executor0 = Outside.service(this,"gus.appli.gusexplorer.scripts.startup.manager.executor0");
		executor1 = Outside.service(this,"gus.appli.gusexplorer.scripts.startup.manager.executor1");
		out = (PrintStream) Outside.resource(this,"sysout");
		
		File dir0 = (File) Outside.resource(this,"defaultdir");
		dir = new File(dir0,"scripts_startup");
		dir.mkdirs();
		
		t = new Thread(this,"THREAD_"+getClass().getName());
		t.start();
	}
	
	
	public void run()
	{
		File[] files = dir.listFiles();
		for(File file:files) handle(file);
		out.println("Startup complete");
	}
	
	
	private void handle(File file)
	{
		try
		{
			if(!file.isFile()) return;
			if(!file.getName().endsWith(".gus")) return;
			
			P p = file.getName().startsWith("_") ? executor1 : executor0;
			
			p.p(file);
			out.println("Script launched at startup: "+file.getName());
		}
		catch(Exception e)
		{Outside.err(this,"handle(File)",e);}
	}
	
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("dir")) return dir;
		if(key.equals("keys")) return new String[]{"dir"};
		
		throw new Exception("Unknown key: "+key);
	}
}
