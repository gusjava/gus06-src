package gus06.entity.gus.service.wrapper2;

import gus06.framework.*;
import java.util.List;
import java.awt.event.ActionListener;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170524";}


	

	public Object t(Object obj) throws Exception
	{
		return new ServiceImpl(obj);
	}

	
	
	private class ServiceImpl implements Service
	{
		private Object target;
		
		public ServiceImpl(Object target)
		{this.target = target;}
		
		private void check(Class c) throws Exception
		{
			if(target==null) throw new Exception("target is null");
			if(!c.isAssignableFrom(target.getClass())) throw new Exception("Feature not available: "+c.getName());
		}
		
		
		public void e() throws Exception
		{
			check(E.class);
			((E) target).e();
		}

		public boolean f(Object obj) throws Exception
		{
			check(F.class);
			return ((F) target).f(obj);
		}
		
		public double h(double value) throws Exception
		{
			check(H.class);
			return ((H) target).h(value);
		}

		public void p(Object obj) throws Exception
		{
			check(P.class);
			((P) target).p(obj);
		}
		
		public Object g() throws Exception
		{
			check(G.class);
			return ((G) target).g();
		}
		
		public void v(String key, Object obj) throws Exception
		{
			check(V.class);
			((V) target).v(key,obj);
		}
		
		public Object r(String key) throws Exception
		{
			check(R.class);
			return ((R) target).r(key);
		}
		
		public Object t(Object obj) throws Exception
		{
			check(T.class);
			return ((T) target).t(obj);
		}
		
		public Object i() throws Exception
		{
			check(I.class);
			return ((I) target).i();
		}
		
		public void addActionListener(ActionListener listener)
		{
			if(target==null || !(target instanceof S)) return;
			((S) target).addActionListener(listener);
		}
		
		public void removeActionListener(ActionListener listener)
		{
			if(target==null || !(target instanceof S)) return;
			((S) target).removeActionListener(listener);
		}
		
		public List listeners()
		{
			if(target==null || !(target instanceof S)) return null;
			return ((S) target).listeners();
		}
		
		public void run()
		{
			if(target==null || !(target instanceof Runnable)) return;
			((Runnable) target).run();
		}
	}
}
