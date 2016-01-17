package gus06.entity.gus.data.perform.opp;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151126";}


	private Service oppFunction;
	
	public EntityImpl() throws Exception
	{
		oppFunction = Outside.service(this,"gus.feature.op.function.opp");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		if(obj instanceof Integer) return new Integer(toInt(obj)*-1);
		if(obj instanceof Double) return new Double(toDouble(obj)*-1);
		if(obj instanceof Float) return new Float(toFloat(obj)*-1);
		if(obj instanceof Long) return new Long(toLong(obj)*-1);
		
		if(obj instanceof H) return opp((H) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
	
	private double toDouble(Object obj)
	{return Double.parseDouble(""+obj);}
	
	private float toFloat(Object obj)
	{return Float.parseFloat(""+obj);}
	
	private long toLong(Object obj)
	{return Long.parseLong(""+obj);}
	
	private H opp(H h) throws Exception
	{return (H) oppFunction.t(h);}
}
