package gus06.entity.gus.sys.script1.executor.type.el.z.else1;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150902";}


	public Object t(Object obj) throws Exception
	{return new Executor((Map) obj);}
	
	
	private class Executor implements P
	{
		private Map tag;
		public Executor(Map tag) {this.tag = tag;}
		
		public void p(Object obj) throws Exception
		{}
	}
}
