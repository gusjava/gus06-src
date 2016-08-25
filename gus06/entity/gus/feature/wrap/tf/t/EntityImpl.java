package gus06.entity.gus.feature.wrap.tf.t;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160413";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		T t = (T) o[0];
		F f = (F) o[1];
		
		return new Wrap(t,f);
	}
	
	
	
	
	
	private class Wrap implements T
	{
		private T t;
		private F f;
		
		public Wrap(T t, F f)
		{
			this.t = t;
			this.f = f;
		}
		
		public Object t(Object obj) throws Exception
		{
			return f.f(obj) ? t.t(obj) : obj;
		}
	}
}
