package gus06.entity.gus.appli.gusclient1.init.sysouterr;

import gus06.framework.*;

public class EntityImpl implements Entity {

	public String creationDate() {return "20140730";}

	private Service outManager;
	private Service errManager;
	private Service supToPrintStream;
	private Service alertManager;

	
	public EntityImpl() throws Exception
	{
		outManager = Outside.service(this,"gus.system.out.manager");
		errManager = Outside.service(this,"gus.system.err.manager");
		supToPrintStream = Outside.service(this,"gus.io.printstream.supporttoprintstream");
		alertManager = Outside.service(this,"gus.appli.gusclient1.alert.manager");
		
		S1 outSup = new S1();
		outManager.p(supToPrintStream.t(outSup));
		alertManager.v("sysout",outSup);
		
		S1 errSup = new S1();
		errManager.p(supToPrintStream.t(errSup));
		alertManager.v("syserr",errSup);
	}
}
