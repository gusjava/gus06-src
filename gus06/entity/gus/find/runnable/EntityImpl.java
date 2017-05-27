package gus06.entity.gus.find.runnable;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161108";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Runnable) return obj;
		if(obj instanceof E) return new Runnable1((E) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class Runnable1 implements Runnable
	{
		private E execute;
		
		public Runnable1(E execute)
		{this.execute = execute;}
		
		public void run()
		{execute(execute);}
	}
	
	
	
	private void execute(E execute)
	{
		try{execute.e();}
		catch(Exception e)
		{Outside.err(this,"execute(E)",e);}
	}
}
