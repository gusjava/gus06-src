package gus06.entity.gus.sys.script1.executor.type.el.r.extends1;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.net.URL;

public class EntityImpl implements Entity, T {
	
	public String creationDate() {return "20151111";}

	
	private Service getParams;
	private Service evalAsObject;
	private Service stackManager;
	private Service engine;

	public EntityImpl() throws Exception
	{
		getParams = Outside.service(this,"gus.sys.script1.access.tag.params1");
		evalAsObject = Outside.service(this,"gus.sys.script1.context.evaluate");
		stackManager = Outside.service(this,"gus.sys.script1.context.stack.manager");
		engine = Outside.service(this,"gus.sys.script1.engine");
	}
	
		
	public Object t(Object obj) throws Exception
	{return new Executor((Map) obj);}
	
	
	/* A TERMINER */
	private class Executor implements P
	{
		private Map tag;
		public Executor(Map tag) {this.tag = tag;}
		
		public void p(Object obj) throws Exception
		{
			Map context = (Map) obj;
			String params = (String) getParams.t(tag);
			
			Object source = evalAsObject.t(new Object[]{context,params});
			
			E stack = (E) stackManager.t(new Map[]{context,tag});
			engine.p(new Object[]{source,context});
			stack.e();
		}
	}
}
