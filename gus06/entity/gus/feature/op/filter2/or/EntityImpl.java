package gus06.entity.gus.feature.op.filter2.or;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150722";}

	
	public Object t(Object obj) throws Exception
	{return new F1((List) obj);}
	
	
	private class F1 implements F
	{
		private List ff;
		public F1(List ff){this.ff = ff;}
		
		public boolean f(Object obj) throws Exception
		{
			for(Object f:ff) if(((F)f).f(obj)) return true;
			return false;
		}
	}
}
