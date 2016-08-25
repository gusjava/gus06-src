package gus06.entity.gus.find.double1;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160705";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		if(obj instanceof Double) return obj;
		if(obj instanceof Number) return new Double(((Number) obj).doubleValue());
		if(obj instanceof String) return new Double((String) obj);
		
		if(obj instanceof double[])
		{
			double[] d = (double[]) obj;
			if(d.length!=1) throw new Exception("Invalid array length: "+d.length);
			return new Double(d[0]);
		}
		
		if(obj instanceof double[][])
		{
			double[][] d = (double[][]) obj;
			if(d.length!=1) throw new Exception("Invalid array length: "+d.length);
			if(d[0].length!=1) throw new Exception("Invalid array length: "+d[0].length);
			return new Double(d[0][0]);
		}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
