package gus06.entity.gus.sys.webserver1.engine.pooler;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141013";}

	public static final int NB = 5;

	private Service sender;
	private Thread[] pool;
	
	
	public EntityImpl() throws Exception
	{
		sender = Outside.service(this,"gus.sys.webserver1.engine.sender");
		pool = new Thread[NB];
	}
	
	
	public void p(Object obj) throws Exception
	{
		Runnable r = new Runnable1(obj);
		int index = waitForAvailable();
		
		pool[index] = new Thread(r,"THREAD_"+getClass().getName()+"_"+index);
		pool[index].start();
	}
	
	
	private int waitForAvailable()
	{
		int i = 0;
		while(!isAvailable(pool[i]))
		{i = i==NB-1?0:i+1;sleep1();}
		return i;
	}
	
	
	private void sleep1()
	{
		try{Thread.sleep(1);}
		catch(Exception e){Outside.err(this,"sleep1()",e);}
	}
	
	
	private boolean isAvailable(Thread t)
	{return t==null || !t.isAlive();}
	
	
	private class Runnable1 implements Runnable
	{
		private Object obj;
		public Runnable1(Object obj){this.obj = obj;}
		public void run(){send(obj);}
	}
	
	private void send(Object obj)
	{
		try{sender.p(obj);}
		catch(Exception e)
		{Outside.err(this,"send(Object)",e);}
	}
}
