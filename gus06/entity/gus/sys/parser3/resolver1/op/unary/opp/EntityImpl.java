package gus06.entity.gus.sys.parser3.resolver1.op.unary.opp;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151029";}


	private Service oppFunction;
	
	public EntityImpl() throws Exception
	{
		oppFunction = Outside.service(this,"gus.feature.op.function.opp");
	}


	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map tag = (Map) o[0];
		T t = (T) o[1];
		
		Object value = t.t(tag);
		if(value==null) return null;
		
		if(value instanceof H)
		{
			return oppFunction.t(value);
		}

		if(value instanceof Integer)
		{
			Integer n = (Integer) value;
			return new Integer(-1*n.intValue());
		}
		if(value instanceof Double)
		{
			Double n = (Double) value;
			return new Double(-1*n.doubleValue());
		}
		if(value instanceof Float)
		{
			Float n = (Float) value;
			return new Float(-1*n.floatValue());
		}
		if(value instanceof Long)
		{
			Long n = (Long) value;
			return new Long(-1*n.longValue());
		}
		
		
		if(value instanceof int[])
		{
			int[] n = (int[]) value;
			int[] n1 = new int[n.length];
			for(int i=0;i<n.length;i++) n1[i] = -1*n[i];
			return n1;
		}
		if(value instanceof double[])
		{
			double[] n = (double[]) value;
			double[] n1 = new double[n.length];
			for(int i=0;i<n.length;i++) n1[i] = -1*n[i];
			return n1;
		}
		if(value instanceof float[])
		{
			float[] n = (float[]) value;
			float[] n1 = new float[n.length];
			for(int i=0;i<n.length;i++) n1[i] = -1*n[i];
			return n1;
		}
		if(value instanceof long[])
		{
			long[] n = (long[]) value;
			long[] n1 = new long[n.length];
			for(int i=0;i<n.length;i++) n1[i] = -1*n[i];
			return n1;
		}
		
		throw new Exception("Invalid value type for operator: "+value.getClass().getName());
	}
}
