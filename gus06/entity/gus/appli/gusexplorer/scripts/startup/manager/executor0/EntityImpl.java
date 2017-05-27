package gus06.entity.gus.appli.gusexplorer.scripts.startup.manager.executor0;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170103";}


	private Service buildE;
	
	public EntityImpl() throws Exception
	{
		buildE = Outside.service(this,"gus.sys.script1.build1.e");
	}
	
	
	public void p(Object obj) throws Exception
	{
		E execute = (E) buildE.t(obj);
		execute.e();
	}
}