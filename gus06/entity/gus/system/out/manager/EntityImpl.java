package gus06.entity.gus.system.out.manager;

import gus06.framework.*;
import java.io.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140730";}

	private Service factory;
	private PrintStream out;
	

	public EntityImpl() throws Exception
	{
		factory = Outside.service(this,"gus.io.printstream.factory.multi.hist");
		
		out = (PrintStream) factory.g();
		
		System.setOut(out);
		out.println("System.out multi initialized");
	}
	
	
	public void p(Object obj) throws Exception
	{((P)out).p(obj);}
}
