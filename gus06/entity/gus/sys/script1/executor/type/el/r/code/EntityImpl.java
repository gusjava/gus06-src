package gus06.entity.gus.sys.script1.executor.type.el.r.code;

import gus06.framework.*;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150906";}

	
	private Service getContent;
	private Service executeCode;

	public EntityImpl() throws Exception
	{
		getContent = Outside.service(this,"gus.sys.script1.access.tag.content1.texttag");
		executeCode = Outside.service(this,"gus.sys.script1.tool.execute.code.block");
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
			String value = (String) getContent.t(tag);
			executeCode.p(new Object[]{value,context});
		}
	}
}
