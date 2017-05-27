package gus06.entity.gus.sys.script1.tool.execute.tag;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, P {
	
	public String creationDate() {return "20150829";}
	

	private Service getExecutor;
//	private Service getScript;
	private Service prepareExecution;
	private Service modifyUserDir;


	public EntityImpl() throws Exception
	{
		getExecutor = Outside.service(this,"gus.sys.script1.access.tag.executor1");
//		getScript = Outside.service(this,"gus.sys.script1.access.tag.stack1.script1");
		prepareExecution = Outside.service(this,"gus.sys.script1.tool.execute.tag.prepare");
		modifyUserDir = Outside.service(this,"gus.system.prop.userdir.modify");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Map[] o = (Map[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map tag = o[0];
		Map context = o[1];
		
		boolean ok = prepareExecution.f(new Map[]{tag,context});
		if(!ok) return;
		
//		File script = (File) getScript.t(tag);
//		File dir0 = null;
//		if(script!=null)
//		dir0 = (File) modifyUserDir.t(script.getParentFile());
		
		try
		{
			P p = (P) getExecutor.t(tag);
			p.p(context);
		}
		catch(Exception e)
		{
			String message = "Failed to execute tag ["+tag+"]";
			throw new Exception(message,e);
		}
//		finally
//		{
//			if(dir0!=null) modifyUserDir.p(dir0);
//		}
	}
}
