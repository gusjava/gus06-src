package gus06.entity.gus.feature.op.sum2.runnable;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150711";}

	
	public Object t(Object obj) throws Exception
	{return new Runnable1((List) obj);}
	
	
	private class Runnable1 implements Runnable
	{
		private List rr;
		public Runnable1(List rr){this.rr = rr;}
		
		public void run()
		{for(Object r:rr) ((Runnable)r).run();}
	}
}
