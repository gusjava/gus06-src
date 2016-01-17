package gus06.entity.gus.convert.gtot;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151123";}


	public Object t(Object obj) throws Exception
	{return new T1((G) obj);}
	
	
	
		
	
	private class T1 implements T
	{
		private G g;
		public T1(G g) {this.g = g;}
		
		public Object t(Object obj) throws Exception
		{return g.g();}
	}
}
