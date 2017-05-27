package gus06.entity.gus.data.perform.exec.tostring.utf8;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170410";}


	private Service exec;
	private Service processToString;


	public EntityImpl() throws Exception
	{
		exec = Outside.service(this,"gus.data.perform.exec");
		processToString = Outside.service(this,"gus.process.tostring.utf8");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Process p = (Process) exec.t(obj);
		return processToString.t(p);
	}
}
