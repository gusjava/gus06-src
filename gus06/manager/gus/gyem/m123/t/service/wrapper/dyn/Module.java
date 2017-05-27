package gus06.manager.gus.gyem.m123.t.service.wrapper.dyn;

import java.util.List;
import java.awt.event.ActionListener;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.framework.*;

public class Module extends GyemSystem implements T {

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		G target = (G) o[0];
		Object src = o[1];
		
		String src_ = (String) ((T) module(M062_T_SERVICE_SRCTOSTRING)).t(src);
		return new ServiceImpl(target,src_);
	}

	
	
	private class ServiceImpl implements Service
	{
	    private G target;
	    private String src_;
	    
	    
	    public ServiceImpl(G target, String src_)
	    {
	        this.src_ = src_;
	        this.target = target;
	    }

	    
	    private Object build(Class c) throws Exception
	    {
	    	Object obj = target.g();
	    	if(obj==null) return null;
	    	if(!c.isAssignableFrom(obj.getClass()))
	    	throw new Exception("Feature "+c.getName()+" not available for "+src_+" (="+obj.getClass().getName()+")");
	    	return obj;
	    }
	    
	    private Object build0(Class c)
	    {
	    	try{
	    		Object obj = target.g();
		    	if(obj==null) return null;
	    		if(!obj.getClass().isAssignableFrom(c)) return null;
	    	}
	    	catch(Exception e){}
	    	return null;
	    }
	    
	    
	    
	    public void e() throws Exception
	    {
	    	E e = (E) build(E.class);
	    	if(e!=null) e.e();
	    }

	    public boolean f(Object obj) throws Exception
	    {
	    	F f = (F) build(F.class);
	    	return f!=null ? f.f(obj) : false;
	    }
	    
	    public double h(double value) throws Exception
	    {
	    	H h = (H) build(H.class);
	    	return h!=null ? h.h(value) : 0;
	    }

	    public void p(Object obj) throws Exception
	    {
	    	P p = (P) build(P.class);
	    	if(p!=null) p.p(obj);
	    }
	    
	    public Object g() throws Exception
	    {
	    	G g = (G) build(G.class);
	    	return g!=null ? g.g() : null;
	    }
	    
	    public void v(String key, Object obj) throws Exception
	    {
	    	V v = (V) build(V.class);
	    	if(v!=null) v.v(key,obj);
	    }
	    
	    public Object r(String key) throws Exception
	    {
	    	R r = (R) build(R.class);
	    	return r!=null ? r.r(key) : null;
	    }
	    
	    public Object t(Object obj) throws Exception
	    {
	    	T t = (T) build(T.class);
	    	return t!=null ? t.t(obj) : null;
	    }
	    
	    public Object i() throws Exception
	    {
	    	I i = (I) build(I.class);
	    	return i!=null ? i.i() : null;
	    }
	    
	    
	    public void addActionListener(ActionListener listener)
	    {
	    	S s = (S) build0(S.class);
	    	if(s!=null) s.addActionListener(listener);
	    }
	    
	    public void removeActionListener(ActionListener listener)
	    {
	    	S s = (S) build0(S.class);
	        if(s!=null) s.removeActionListener(listener);
	    }
	    
	    public List listeners()
	    {
	    	S s = (S) build0(S.class);
	        return s!=null ? s.listeners() : null;
	    }
	    
	    public void run()
	    {
	    	Runnable r = (Runnable) build0(Runnable.class);
	        if(r!=null) r.run();
	    }
	}
}