package gus06.entity.gus.sys.expression1.apply.op._watch_evts;

import gus06.framework.*;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161216";}

	
	private Service perform;
	
	public EntityImpl() throws Exception
	{perform = Outside.service(this,"gus.support.watch.evts");}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof S) return new T1((S) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class T1 implements T
	{
		private S support;
		
		public T1(S support)
		{this.support = support;}
		
		public Object t(Object obj) throws Exception
		{return new E1(support, (E) obj);}
	}
	
	
	
	
	private class E1 implements E
	{
		private S support;
		private E execute;
		
		public E1(S support, E execute)
		{
			this.support = support;
			this.execute = execute;
		}
		
		public void e() throws Exception
		{
			perform.p(new Object[]{support,execute});
		}
	}
}
