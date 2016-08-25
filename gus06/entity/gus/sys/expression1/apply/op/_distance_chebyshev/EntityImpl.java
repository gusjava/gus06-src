package gus06.entity.gus.sys.expression1.apply.op._distance_chebyshev;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160711";}


	private Service perform;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.math.tabdouble.distance.chebyshev");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof double[]) return new T1((double[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private double[] d1;
		public T1(double[] d1) {this.d1 = d1;}
		
		public Object t(Object obj) throws Exception
		{
			double[] d2 = (double[]) obj;
			return perform.t(new Object[]{d1,d2});
		}
	}
}
