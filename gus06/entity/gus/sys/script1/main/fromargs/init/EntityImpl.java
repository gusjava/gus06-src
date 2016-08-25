package gus06.entity.gus.sys.script1.main.fromargs.init;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;

public class EntityImpl implements Entity {

	public String creationDate() {return "20160602";}


	private Service main;
	private Service argsLine;
	
	private String line;
	private PrintStream out;


	public EntityImpl() throws Exception
	{
		main = Outside.service(this,"gus.sys.script1.main.main1");
		argsLine = Outside.service(this,"gus.app.argsline");
		out = (PrintStream) Outside.resource(this,"sysout0");
		
		line = (String) argsLine.g();
		if(line==null) return;
		
		perform();
		System.exit(0);
	}
	
	
	
	private void perform()
	{
		try
		{
			File file = new File(line);
			if(!file.isFile()) throw new Exception("Script file not found: " + file);
			file = file.getCanonicalFile();
			
			out.println("Executing gus script: "+file);
			main.p(new Object[]{file,out});
		}
		catch(Exception e)
		{e.printStackTrace();}
	}

}
