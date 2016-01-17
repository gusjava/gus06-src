package gus06.entity.gus.app.restart1;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150626";}
	
	public static final String LAUNCHER = "launcher";


	private Service copy;
	private Service appJar;
	private Service launchJar;

	public EntityImpl() throws Exception
	{
		copy = Outside.service(this,"gus.file.op.copy.replace");
		appJar = Outside.service(this,"gus.app.jarfile");
		launchJar = Outside.service(this,"gus.java.launchjar");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File out = (File) obj;
		File in = (File) appJar.g();
		
		String in_ = in.getAbsolutePath();
		String out_ = out.getAbsolutePath();
		
		if(in_.equals(out_)) return;
		
		copy.p(new File[]{in,out});
		
		String arg = LAUNCHER+"="+in_;
		launchJar.p(new Object[]{out,arg});
		System.exit(0);
	}
}
