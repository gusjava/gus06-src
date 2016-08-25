package gus06.entity.gus.feature.wrap.ttf.t;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160413";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		T t1 = (T) o[0];
		T t2 = (T) o[1];
		F f = (F) o[2];
		
		return new Wrap(t1,t2,f);
	}
	
	
	
	
	
	private class Wrap implements T
	{
		private T t1;
		private T t2;
		private F f;
		
		public Wrap(T t1, T t2, F f)
		{
			this.t1 = t1;
			this.t2 = t2;
			this.f = f;
		}
		
		public Object t(Object obj) throws Exception
		{
			return f.f(obj) ? t1.t(obj) : t2.t(obj);
		}
	}
}
