package gus06.entity.gus.java.compiler.handleprocess.is;

import gus06.framework.*;
import java.io.PrintStream;

public class EntityImpl implements Entity, P, F {

	public String creationDate() {return "20140725";}

	public static final long TIMEOUT = 120000L;

	private Service killer;
	private Service ioTransfer;
	private Service findPrintStream;
	private PrintStream out;


	public EntityImpl() throws Exception
	{
		killer = Outside.service(this,"gus.process.timeout.killer");
		ioTransfer = Outside.service(this,"gus.io.transfer.toprintstream");
		findPrintStream = Outside.service(this,"gus.find.printstream");
		out = (PrintStream) Outside.resource(this,"call.g#gus.java.compiler.outputanalyzer");
	}


	public void p(Object obj) throws Exception
	{
		Process p1 = findProcess(obj);
		PrintStream p2 = findPrintStream(obj);
		
		int code = handleProcess(p1,p2);
		
		if(code==0) p2.println("compilation successful");
		else p2.println("compilation failed (code="+code+")");
	}


	public boolean f(Object obj) throws Exception
	{
		Process p1 = findProcess(obj);
		PrintStream p2 = findPrintStream(obj);
		
		return handleProcess(p1,p2)==0;
	}


	private int handleProcess(Process p1, PrintStream p2) throws Exception
	{
		killer.p(new Object[]{p1,new Long(TIMEOUT)});
		ioTransfer.p(new Object[]{p1.getInputStream(),p2});
		return p1.exitValue();
	}
	
	
	
	private Process findProcess(Object obj) throws Exception
	{
		if(obj instanceof Process) return (Process) obj;
		
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		return (Process) o[0];
	}
	
	
	private PrintStream findPrintStream(Object obj) throws Exception
	{
		if(obj instanceof Process) return out;
		
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		if(o[1]==null) return out;
		
		return (PrintStream) findPrintStream.t(o[1]);
	}
}
