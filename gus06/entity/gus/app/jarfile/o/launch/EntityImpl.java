package gus06.entity.gus.app.jarfile.o.launch;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140803";}


	private Service procHolder;
	private Service jarLauncher;
	private Service appJar;
	private StringBuffer args;
	

	public EntityImpl() throws Exception
	{
		procHolder = Outside.service(this,"gus.app.jarfile.o.process");
		jarLauncher = Outside.service(this,"gus.java.launchjar");
		appJar = Outside.service(this,"gus.app.jarfile.o");
	}
	
	
	public void e() throws Exception
	{
		File file = (File) appJar.g();
	
		args = new StringBuffer();
		put("root","root_test");
		put_p("app.title","Gus Client Test");
		put_p("app.size","1500 600");
		put_p("dev.pseudo","test");
		put_p("dev.console.show","true");

		Process proc = (Process) jarLauncher.t(new Object[]{file,args.toString()});
		procHolder.p(proc);
	}
	
	
		
	private void put_p(String key, String value)
	{put("p."+key,value);}
	
	private void put(String key, String value)
	{
		if(args.length()>0) args.append(";");
		args.append(key+"="+value);
	}
}
