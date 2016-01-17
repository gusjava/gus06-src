package gus06.entity.gus.file.string.perform.execute.script1;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151024";}

	private Service engine;
	private Service contextBuilder;
	private Service lazyPrintStream;
	private Service writeEx;

	public EntityImpl() throws Exception
	{
		engine = Outside.service(this,"gus.sys.script1.engine");
		contextBuilder = Outside.service(this,"gus.sys.script1.context.builder1");
		lazyPrintStream = Outside.service(this,"gus.io.printstream.lazy.utf8");
		writeEx = Outside.service(this,"gus.file.write.string.exception");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		File[] f = (File[]) obj;
		if(f.length!=2) throw new Exception("Wrong data number: "+f.length);
		
		File scriptFile = f[0];
		File outputFile = f[1];
		
		execute(scriptFile,outputFile);
	}
	
	
	
	private void execute(File scriptFile, File outputFile) throws Exception
	{
		try
		{
			PrintStream p = (PrintStream) lazyPrintStream.t(outputFile);
			Map context = (Map) contextBuilder.t(p);
			
			engine.p(new Object[]{scriptFile,context});
		}
		catch(Exception e)
		{
			Outside.err(this,"execute(File,File)",e);
			writeEx.p(new Object[]{outputFile,e});
		}
	}
}
