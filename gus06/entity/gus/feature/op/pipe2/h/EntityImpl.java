package gus06.entity.gus.feature.op.pipe2.h;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150711";}

	
	public Object t(Object obj) throws Exception
	{return new H1((List) obj);}
	
	
	private class H1 implements H
	{
		private List hh;
		public H1(List hh){this.hh = hh;}
		
		public double h(double v) throws Exception
		{
			double r = v;
			for(Object h:hh) r = ((H)h).h(r);
			return r;
		}
	}
}
