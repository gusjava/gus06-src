package gus06.entity.gus.sys.script1.executor.type.el.z.call;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {
	
	public String creationDate() {return "20151103";}

	
	private Service executeAll;
	private Service getParams;
	private Service evalAsString;
	private Service stackManager;
	private Service searchBlockTag;


	public EntityImpl() throws Exception
	{
		executeAll = Outside.service(this,"gus.sys.script1.tool.execute.content.all");
		getParams = Outside.service(this,"gus.sys.script1.access.tag.params1");
		evalAsString = Outside.service(this,"gus.sys.script1.context.evaluate.string1");
		stackManager = Outside.service(this,"gus.sys.script1.context.stack.manager");
		searchBlockTag = Outside.service(this,"gus.sys.script1.access.context.search.block");
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
			String blockName = (String) evalAsString.t(new Object[]{context,params});
			Map block = (Map) searchBlockTag.t(new Object[]{context,blockName});
			
			if(block==null) throw new Exception("Block undefined: "+blockName);
			
			Object stack = stackManager.t(new Map[]{context,tag});
			executeAll.p(new Map[]{block,context});
			((E) stack).e();
		}
	}
}
