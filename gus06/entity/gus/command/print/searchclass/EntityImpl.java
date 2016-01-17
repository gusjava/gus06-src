package gus06.entity.gus.command.print.searchclass;

import gus06.framework.*;
import java.io.PrintStream;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140728";}


	private Service searchClass;
	private PrintStream out;
	
	public EntityImpl() throws Exception
	{
		searchClass = Outside.service(this,"gus.java.searchclass.fromrt.preferred");
		out = (PrintStream) Outside.resource(this,"sysout");
	}
	
	
	public void p(Object obj) throws Exception
	{
		String classpath = (String) searchClass.t(obj);
		out.println(classpath);
	}
}
