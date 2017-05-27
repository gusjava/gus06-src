package gus06.entity.gus.sys.expression1.apply.op._watch_evt;

import gus06.framework.*;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161216";}

	
	private Service perform;
	
	public EntityImpl() throws Exception
	{perform = Outside.service(this,"gus.support.watch.evt");}
	
	
	
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
		{return new T2(support, (String) obj);}
	}
	
	
	private class T2 implements T
	{
		private S support;
		private String id;
		
		public T2(S support, String id)
		{
			this.support = support;
			this.id = id;
		}
		
		public Object t(Object obj) throws Exception
		{return new E1(support, id, (E) obj);}
	}
	
	
	private class E1 implements E
	{
		private S support;
		private String id;
		private E execute;
		
		public E1(S support, String id, E execute)
		{
			this.support = support;
			this.id = id;
			this.execute = execute;
		}
		
		public void e() throws Exception
		{
			perform.p(new Object[]{support,id,execute});
		}
	}
}
