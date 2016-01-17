package gus06.entity.gus.convert.htot;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151123";}


	public Object t(Object obj) throws Exception
	{return new T1((H) obj);}
	
	
	
		
	
	private class T1 implements T
	{
		private H h;
		public T1(H h) {this.h = h;}
		
		public Object t(Object obj) throws Exception
		{return new Double(h.h(toDouble(obj)));}
	}
	
	
	private double toDouble(Object obj)
	{return Double.parseDouble(""+obj);}
}
