package gus06.entity.gus.find.execute;

import gus06.framework.*;
import javax.swing.Action;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170525";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof E) return obj;
		if(obj instanceof Runnable) return new E1((Runnable) obj);
		if(obj instanceof Thread) return new E2((Thread) obj);
		if(obj instanceof Action) return new E3((Action) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class E1 implements E
	{
		private Runnable runnable;
		
		public E1(Runnable runnable)
		{this.runnable = runnable;}

		public void e() throws Exception
		{runnable.run();}
	}
	
	
	private class E2 implements E
	{
		private Thread thread;
		
		public E2(Thread thread)
		{this.thread = thread;}

		public void e() throws Exception
		{thread.start();}
	}
	
	
	
	private class E3 implements E
	{
		private Action action;
		
		public E3(Action action)
		{this.action = action;}

		public void e() throws Exception
		{action.actionPerformed(null);}
	}
}
