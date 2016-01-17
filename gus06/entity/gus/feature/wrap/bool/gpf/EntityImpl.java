package gus06.entity.gus.feature.wrap.bool.gpf;

import gus06.framework.*;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20150708";}

	
	
	public Object t(Object obj) throws Exception
	{return new Wrap((Boolean) obj);}
	
	public Object g() throws Exception
	{return new Wrap(Boolean.TRUE);}
	
	
	
		
	
	private class Wrap implements G, F, P
	{
		private Boolean data;
		public Wrap(Boolean data) {this.data = data;}
		
		public Object g() throws Exception
		{return data;}
		
		public void p(Object obj) throws Exception
		{this.data = (Boolean) obj;}
		
		public boolean f(Object obj) throws Exception
		{return data.booleanValue();}
	}
}
