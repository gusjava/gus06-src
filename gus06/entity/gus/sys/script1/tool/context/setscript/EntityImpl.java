package gus06.entity.gus.sys.script1.tool.context.setscript;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151103";}
	
	public static final String P_SCRIPT = "script";

	private Service getPool;

	public EntityImpl() throws Exception
	{
		getPool = Outside.service(this,"gus.sys.script1.access.context.pool1.latest");
	}
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map context = (Map) o[0];
		File file = (File) o[1];
		
		if(!file.isFile()) throw new Exception("Script file not found: "+file);
		
		Map pool = (Map) getPool.t(context);
		pool.put(P_SCRIPT,file);
	}
}
