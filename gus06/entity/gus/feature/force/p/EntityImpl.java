package gus06.entity.gus.feature.force.p;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170408";}

	
	
	public Object t(Object obj) throws Exception
	{return new P1((P) obj);}
	
	
	private class P1 implements P
	{
		private P p;
		public P1(P p) {this.p = p;}
		
		public void p(Object obj) throws Exception
		{
			while(true)
			{
				try
				{
					p.p(obj);
					return;
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