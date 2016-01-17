package gus06.entity.gus.sys.script1.engine.fromfile;

import gus06.framework.*;
import java.io.File;
import java.io.PrintStream;
import java.util.Map;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20151103";}

	private Service engine;
	private Service readText;
	private Service setScript;
	private Service modifyUserDir;

	public EntityImpl() throws Exception
	{
		engine = Outside.service(this,"gus.sys.script1.engine.fromtext");
		readText = Outside.service(this,"gus.file.read.string.autodetect");
		setScript = Outside.service(this,"gus.sys.script1.tool.context.setscript");
		modifyUserDir = Outside.service(this,"gus.system.prop.userdir.modify");
	}

	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Map context = (Map) o[1];
		Map tag = null;
		
		File dir0 = (File) modifyUserDir.t(file.getParentFile());
		
		try
		{
			setScript.p(new Object[]{context,file});
			String text = (String) readText.t(file);
			tag = (Map) engine.t(new Object[]{text,context});
		}
		finally
		{
			modifyUserDir.p(dir0);
		}
		
		return tag;
	}
}
