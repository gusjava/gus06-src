package gus06.entity.gus.feature.op.col.keep.mapkey.f;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150707";}


	
	public Object t(Object obj) throws Exception
	{return new P1((F) obj);}
	
	
	
	
	private class P1 implements P
	{
		private F f;
		public P1(F f) {this.f = f;}
		
		public void p(Object obj) throws Exception
		{
			Map m = (Map) obj;
			Iterator it = m.keySet().iterator();
			while(it.hasNext()) if(!f.f(it.next())) it.remove();
		}
	}
}
