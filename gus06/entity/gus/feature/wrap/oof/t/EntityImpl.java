package gus06.entity.gus.feature.wrap.oof.t;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160413";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Object obj1 = o[0];
		Object obj2 = o[1];
		F f = (F) o[2];
		
		return new Wrap(obj1,obj2,f);
	}
	
	
	
	
	
	private class Wrap implements T
	{
		private Object obj1;
		private Object obj2;
		private F f;
		
		public Wrap(Object obj1, Object obj2, F f)
		{
			this.obj1 = obj1;
			this.obj2 = obj2;
			this.f = f;
		}
		
		public Object t(Object obj) throws Exception
		{
			return f.f(obj) ? obj1 : obj2;
		}
	}
}
