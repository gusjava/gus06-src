package gus06.entity.gus.sys.script1.executor.type.el.r.ignore;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150829";}


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
