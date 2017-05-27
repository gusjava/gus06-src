package gus06.entity.gus.feature.wrap.builder1;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.awt.event.ActionListener;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161212";}
	
	
	private Service wrapObj;
	private Service wrapBool;
	private Service wrapDouble;
	
	public EntityImpl() throws Exception
	{
		wrapObj = Outside.service(this,"gus.feature.wrap.o.gpti");
		wrapBool = Outside.service(this,"gus.feature.wrap.bool.gpft");
		wrapDouble = Outside.service(this,"gus.feature.wrap.double1.gph");
	}
	
	
	public Object t(Object obj) throws Exception
	{return new Wrap((Map) obj);}
	
	
	
	private I toI(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof I) return (I) obj;
		return (I) wrapObj.t(obj);
	}
	
	private G toG(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof G) return (G) obj;
		return (G) wrapObj.t(obj);
	}
	
	private F toF(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof F) return (F) obj;
		if(obj instanceof Boolean) return (F) wrapBool.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private H toH(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof H) return (H) obj;
		if(obj instanceof Double) return (H) wrapDouble.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class Wrap implements E, G, P, T, F, H, I, R, V, S
	{
		private E e;
		private G g;
		private P p;
		private T t;
		private F f;
		private H h;
		private I i;
		private R r;
		private V v;
		private S s;
		
		public Wrap(Map map) throws Exception
		{
			e = (E) get(map,"E");
			g = toG(get(map,"G"));
			p = (P) get(map,"P");
			t = (T) get(map,"T");
			f = toF(get(map,"F"));
			h = toH(get(map,"H"));
			i = toI(get(map,"I"));
			r = (R) get(map,"R");
			v = (V) get(map,"V");
			s = (S) get(map,"S");
		}
		
		private Object get(Map map, String key)
		{
			if(map==null) return null;
			if(!map.containsKey(key)) return null;
			return map.get(key);
		}
		
		private void check(Object obj, String feature) throws Exception
		{if(obj==null) throw new Exception("Feature not available: "+feature);}
		
		
		
		public void e() throws Exception
		{
			check(e,"E");
			e.e();
		}
		
		public Object g() throws Exception
		{
			check(g,"G");
			return g.g();
		}
		
		public void p(Object obj) throws Exception
		{
			check(p,"P");
			p.p(obj);
		}
		
		public Object t(Object obj) throws Exception
		{
			check(t,"T");
			return t.t(obj);
		}
		
		public boolean f(Object obj) throws Exception
		{
			check(f,"F");
			return f.f(obj);
		}
		
		public double h(double value) throws Exception
		{
			check(h,"H");
			return h.h(value);
		}
		
		public Object i() throws Exception
		{
			check(i,"I");
			return i.i();
		}
		
		public Object r(String key) throws Exception
		{
			check(r,"R");
			return r.r(key);
		}
		
		public void v(String key, Object obj) throws Exception
		{
			check(v,"V");
			v.v(key,obj);
		}
		
		public void addActionListener(ActionListener l)
		{
			if(s!=null) s.addActionListener(l);
		}
		
		public void removeActionListener(ActionListener l)
		{
			if(s!=null) s.removeActionListener(l);
		}
		
		public List listeners()
		{
			return s!=null ? s.listeners() : null;
		}
	}
}
