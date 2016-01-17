package gus06.entity.gus.sys.script1.executor.type.el.op.comment;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150829";}


	private Service getParams;
	private Service op;

	public EntityImpl() throws Exception
	{
		getParams = Outside.service(this,"gus.sys.script1.access.tag.params1");
		op = Outside.service(this,"gus.sys.script1.tool.execute.code.op.comment");
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
			String params = (String) getParams.t(tag);
			op.p(new Object[]{params,context});
		}
	}
}
