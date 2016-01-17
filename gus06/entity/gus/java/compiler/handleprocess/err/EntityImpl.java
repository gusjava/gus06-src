package gus06.entity.gus.java.compiler.handleprocess.err;

import gus06.framework.*;
import java.io.PrintStream;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140725";}

	public static final long TIMEOUT = 120000L;

	private Service killer;
	private Service ioTransfer;
	private PrintStream out;


	public EntityImpl() throws Exception
	{
		killer = Outside.service(this,"gus.process.timeout.killer");
		ioTransfer = Outside.service(this,"gus.io.transfer.toprintstream");
		out = (PrintStream) Outside.resource(this,"call.g#gus.java.compiler.outputanalyzer");
	}


	public void p(Object obj) throws Exception
	{
		int code = pr((Process) obj);
		if(code==0) out.println("compilation successful");
		else out.println("compilation failed (code="+code+")");
	}


	public boolean f(Object obj) throws Exception
	{return pr((Process) obj)==0;}


	private int pr(Process pr) throws Exception
	{
		killer.p(new Object[]{pr,new Long(TIMEOUT)});
		ioTransfer.p(new Object[]{pr.getErrorStream(),out});
		return pr.exitValue();
	}
}
