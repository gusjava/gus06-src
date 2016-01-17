package gus06.entity.gus.sys.script1.context.builder1.output;

import gus06.framework.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150905";}

	public static final String ENABLED = "enabled";
	public static final String CLEAR = "clear";
	public static final String ADD = "add";
	public static final String REMOVE = "remove";
	public static final String REDIRECT = "redirect";
	
	
	private Service buildP;
	
	public EntityImpl() throws Exception
	{
		buildP = Outside.service(this,"gus.find.p");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		return new Output(obj);
	}
	
	
	
	
	private class Output extends S1 implements P, V, R, F {
		
		private P p;
		private P p0;
		
		private List<T> trans;
		private boolean enabled;
		
		public Output(Object obj) throws Exception
		{
			p = (P) buildP.t(obj);
			p0 = null;
			trans = new ArrayList<>();
			enabled = true;
		}
		
		public void p(Object obj) throws Exception
		{
			if(!enabled) return;
			
			if(obj==null) obj = "null";
			for(T t:trans) obj = t.t(obj);
			
			if(p0!=null) p0.p(obj);
			else p.p(obj);
			
			outputCalled();
		}
		
		public void v(String key, Object obj) throws Exception
		{
			if(key.equals(ENABLED)) {enabled((String) obj);return;}
			if(key.equals(REDIRECT)) {redirect(obj);return;}
			if(key.equals(ADD)) {add((T) obj);return;}
			if(key.equals(REMOVE)) {remove((T) obj);return;}
			if(key.equals(CLEAR)) {clear();return;}
			
			throw new Exception("Unknown key: "+key);
		}
		
		public Object r(String key) throws Exception
		{
			if(key.equals("trans")) return trans;
			if(key.equals("p")) return p;
			if(key.equals("p0")) return p0;
			
			if(key.equals("keys")) return new String[]{"trans","p","p0"};
			throw new Exception("Unkwown key: "+key);
		}
		
		public boolean f(Object obj) throws Exception
		{return enabled;}
		
		
		
		
		private void enabled(String v)
		{enabled = Boolean.parseBoolean(v);}
		
		private void redirect(Object obj) throws Exception
		{p0 = (P) buildP.t(obj);}
		
		private void add(T t)
		{trans.add(t);}
		
		private void remove(T t)
		{trans.remove(t);}
		
		private void clear()
		{
			trans.clear();
			p0 = null;
		}
		
		
		
		private void outputCalled()
		{send(this,"outputCalled()");}
	}
}
