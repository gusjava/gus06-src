package gus06.manager.gus.gyem.tools;

import java.lang.Thread.UncaughtExceptionHandler;
import gus06.framework.Entity;


public class Tool_Entity {

	public static void checkEntityName(String name) throws Exception
	{
		if(name==null) throw new Exception("Invalid entity name: null");
		if(name.equals("")) throw new Exception("Invalid entity name: empty string");
		if(!name.matches("([\\w]+\\.)*[\\w]+")) throw new Exception("Invalid entity name: ["+name+"]");
		
		String[] nn = name.split("\\.");
		for(String n:nn) if(Tool_Java.isKeyword(n)) throw new Exception("Invalid entity name: ["+name+"]");
	}
	
	
	
	
	
	
	
	private static EntityThread t; 
	
	
	
	public static Entity createEntity(Class c) throws Exception
	{
		if(t!=null) return (Entity) c.newInstance();
		
		Entity entity = null;
		
		synchronized(Tool_Entity.class)
		{
			t = new EntityThread(c);
			t.init();
		
			entity = t.entity();
			t = null;
		}
		
		return entity;
	}
	
	
	
	
	
	
	private static class EntityThread extends Thread implements UncaughtExceptionHandler
	{
		public static final long TIMEOUT = 10000L;
	
		private Class c;
		private Object result;
		private UncaughtExceptionHandler ueh;
	
		private Entity entity;
	
	
	
		public EntityThread(Class c) throws Exception
		{this.c = c;}
		
		
		
		public void init() throws Exception
		{
			ueh = Thread.getDefaultUncaughtExceptionHandler();
			Thread.setDefaultUncaughtExceptionHandler(this);
		
			start();
			
			long t1 = System.currentTimeMillis();
			while(isAlive() && System.currentTimeMillis()-t1 < TIMEOUT)
			{Thread.sleep(1);}
			
			//join(TIMEOUT);
			
		
			Thread.setDefaultUncaughtExceptionHandler(ueh);
		
			if(result==null)
				throw new Exception("Class instantiation takes too long: "+c.getName()+"\n"+
						"state:"+getState()+"\n"+
						"BLOCKING STACK:\n"+
						steToString());
			
			if(result instanceof Exception)
				throw (Exception) result;
			
			if(result instanceof Throwable)
				throw new Exception((Throwable) result);
			
			if(!(result instanceof Entity))
				throw new Exception("Failed to build entity from class: "+c.getName());
		
			entity = (Entity) result;
		}
	
	
	
		public void run()
		{
			try{result = c.newInstance();}
			catch(InstantiationException e){result = e;}
			catch(IllegalAccessException e){result = e;}
		}
	
	
		public void uncaughtException(Thread t, Throwable e)
		{if(t==this) result = e;}
	
		public Entity entity()
		{return entity;}
	
	
		private String steToString()
		{
			StackTraceElement[] ste = getStackTrace();
			StringBuffer b = new StringBuffer();
			for(int i=0;i<ste.length;i++) b.append(location(ste[i])+"\n");
			return "["+b.toString()+"]";
		}
	
		private String location(StackTraceElement ste)
		{
			if(ste==null) return "null";
			return ste.getClassName()+"@"+ste.getMethodName()+" ("+ste.getFileName()+":"+ste.getLineNumber()+")";
		}
	}
	
	
	
	
	
}