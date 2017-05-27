package gus06.entity.gus.sys.crawler1.engine;

import gus06.framework.*;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.io.PrintStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170114";}
	
	
	private PrintStream out;

	public EntityImpl() throws Exception
	{
		out = (PrintStream) Outside.resource(this,"sysout");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length==2) return perform(o[0],(T)o[1],null); 
		if(o.length==3) return perform(o[0],(T)o[1],(F)o[2]); 
		
		throw new Exception("Wrong data number: "+o.length);
	}
	
	
	private Set perform(Object element0, T t, F f) throws Exception
	{
		Set done = new HashSet();
		List pending = new ArrayList();
		
		done.add(element0);
		pending.add(element0);
		
		while(!pending.isEmpty())
		{
			Object element = pending.remove(0);
			
			out.println("crawling "+element);
			Collection res = (Collection) t.t(element);
			
			Iterator it = res.iterator();
			while(it.hasNext())
			{
				Object r = it.next();
				if(validResult(f,r) && !done.contains(r))
				{
					done.add(r);
					pending.add(r);
				}
			}
			out.println("res="+res.size()+", done="+done.size()+", pending="+pending.size());
		}
		return done;
	}
	
	private boolean validResult(F f, Object el) throws Exception
	{return f==null || f.f(el);}
}
