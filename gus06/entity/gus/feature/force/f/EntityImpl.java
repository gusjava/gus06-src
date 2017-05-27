package gus06.entity.gus.feature.force.f;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170408";}

	
	
	public Object t(Object obj) throws Exception
	{return new F1((F) obj);}
	
	
	private class F1 implements F
	{
		private F f;
		public F1(F f) {this.f = f;}
		
		public boolean f(Object obj) throws Exception
		{
			while(true)
			{
				try
				{
					return f.f(obj);
				}
				catch(Exception ex)
				{
					sleep1();
				}
			}
		}
	}
	
	
	private void sleep1()
	{
		try{Thread.sleep(1);}
		catch(InterruptedException e){}
	}
}