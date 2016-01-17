package gus06.entity.gus.system.err.manager;

import gus06.framework.*;
import java.io.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140730";}

	private Service factory;
	private PrintStream p1;
	

	public EntityImpl() throws Exception
	{
		factory = Outside.service(this,"gus.io.printstream.factory.multi.hist");
		
		p1 = (PrintStream) factory.g();
		((P)p1).p(System.err);
		System.setErr(p1);
	}
	
	
	public void p(Object obj) throws Exception
	{((P)p1).p(obj);}
}
