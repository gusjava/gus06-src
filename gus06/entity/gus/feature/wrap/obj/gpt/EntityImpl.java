package gus06.entity.gus.feature.wrap.obj.gpt;

import gus06.framework.*;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20150707";}

	
	
	public Object t(Object obj) throws Exception
	{return new Wrap(obj);}
	
	public Object g() throws Exception
	{return new Wrap(null);}
	
	
	
		
	
	private class Wrap implements G, T, P
	{
		private Object data;
		public Wrap(Object data) {this.data = data;}
		
		public Object g() throws Exception
		{return data;}
		
		public void p(Object obj) throws Exception
		{this.data = obj;}
		
		public Object t(Object obj) throws Exception
		{return data;}
	}
}
