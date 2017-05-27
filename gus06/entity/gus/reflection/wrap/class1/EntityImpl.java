package gus06.entity.gus.reflection.wrap.class1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160910";}


	private Service analyze;
	
	public EntityImpl() throws Exception
	{
		analyze = Outside.service(this,"gus.reflection.wrap.class1.analyze");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return new Holder(obj);
	}
	
	
	
	private class Holder implements T, G, P
	{
		private Object data;
		
		public Holder(Object data)
		{this.data = data;}
		
		public void p(Object obj) throws Exception
		{data = obj;}
		
		public Object g() throws Exception
		{return data;}
		
		public Object t(Object obj) throws Exception
		{return analyze.t(new Object[]{data,obj});}
	}
	
}