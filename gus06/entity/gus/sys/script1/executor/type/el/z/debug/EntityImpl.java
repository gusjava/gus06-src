package gus06.entity.gus.sys.script1.executor.type.el.z.debug;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151111";}


	private Service getOutput;

	public EntityImpl() throws Exception
	{
		getOutput = Outside.service(this,"gus.sys.script1.access.context.output0");
	}

	
	
	public Object t(Object obj) throws Exception
	{return new Executor((Map) obj);}
	
	
	
	private class Executor implements P
	{
		private Map tag;
		public Executor(Map tag) {this.tag = tag;}
		
		public void p(Object obj) throws Exception
		{
			Map context = (Map) obj;
			P output = (P) getOutput.t(context);
			if(output==null) return;
			
			output.p("DEBUG !!!");
		}
	}
}
