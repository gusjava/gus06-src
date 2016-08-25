package gus06.entity.gus.sys.script1.engine.fromfile;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;
import java.util.Map;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20151103";}
	
	public static final String X_SCRIPT = "script";
	public static final String C_EXECUTION = "execution";

	private Service readText;
	private Service retrieveBuilder;
	private Service retrieveExecutor;
	
	
	

	public EntityImpl() throws Exception
	{
		readText = Outside.service(this,"gus.file.read.string.autodetect");
		retrieveBuilder = Outside.service(this,"gus.sys.script1.access.context.builder");
		retrieveExecutor = Outside.service(this,"gus.sys.script1.access.context.executor");
	}

	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Map context = (Map) o[1];
		
		Map execution = (Map) get(context,C_EXECUTION);
		execution.put(X_SCRIPT,file);
		
		Map tag = null;
		
		try
		{
			T builder = (T) retrieveBuilder.t(context);
			P executor = (P) retrieveExecutor.t(context);
			String input = (String) readText.t(file);
			
			tag = (Map) builder.t(input);
			executor.p(new Map[]{tag,context});
		}
		catch(Exception e)
		{
			String message = "Failed to execute gus script: "+file;
			throw new Exception(message,e);
		}
		
		return tag;
	}
	
	
	
	
	private Object get(Map map, String key)
	{return map.containsKey(key)?map.get(key):null;}
}
