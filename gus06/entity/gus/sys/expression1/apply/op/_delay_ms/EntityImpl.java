package gus06.entity.gus.sys.expression1.apply.op._delay_ms;

import gus06.framework.*;
import java.util.Timer;
import java.util.TimerTask;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160924";}


	private Timer timer;
	
	public EntityImpl() throws Exception
	{timer = new Timer("TIMER_"+getClass().getName());}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof E) return new T1((E) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class T1 implements T
	{
		private E e;
		public T1(E e) {this.e = e;}
		
		public Object t(Object obj) throws Exception
		{return new E1(e,toLong(obj));}
	}
	
	
	
	private class E1 implements E
	{
		private E e;
		private long t;
		
		public E1(E e, long t)
		{
			this.e = e;
			this.t = t;
		}
		
		public void e() throws Exception
		{
			TimerTask task = new TimerTask()
			{public void run() {perform();}};
			
			timer.schedule(task,t);
		}
		
		private void perform()
		{execute(e);}
	}
	
	
	private long toLong(Object obj)
	{return Long.parseLong(""+obj);}
	
	
	
	private void execute(E execute)
	{
		try{execute.e();}
		catch(Exception e)
		{Outside.err(this,"execute(E)",e);}
	}

}
