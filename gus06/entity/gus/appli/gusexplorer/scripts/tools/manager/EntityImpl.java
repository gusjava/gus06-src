package gus06.entity.gus.appli.gusexplorer.scripts.tools.manager;

import gus06.framework.*;
import java.util.List;
import java.util.Arrays;
import java.io.File;

public class EntityImpl extends S1 implements Entity, R, P, G {

	public String creationDate() {return "20160909";}


	private Service buildE;
	private Service listing;
	private Service trigger;

	private File dir;
	
	
	public EntityImpl() throws Exception
	{
		buildE = Outside.service(this,"gus.sys.script1.build1.e");
		listing = Outside.service(this,"gus.dir.listing0.files.names0");
		trigger = Outside.service(this,"gus.support1.cust.trigger.s1");
		
		File dir0 = (File) Outside.resource(this,"defaultdir");
		
		dir = new File(dir0,"scripts_tools");
		dir.mkdirs();
		
		trigger.p(this);
	}
	
	
	public Object g() throws Exception
	{
		String[] l = (String[]) listing.t(dir);
		return Arrays.asList(l);
	}
	
	
	public void p(Object obj) throws Exception
	{
		String name = (String) obj;
		File f = file(name);
		if(!f.exists()) throw new Exception("Script file not found: "+f);
		
		E execute = (E) buildE.t(f);
		execute.e();
	}
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("dir")) return dir;
		if(key.equals("keys")) return new String[]{"dir"};
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	private File file(String name)
	{return new File(dir,name+".gus");}
}
