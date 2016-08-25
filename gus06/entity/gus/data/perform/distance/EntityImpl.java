package gus06.entity.gus.data.perform.distance;

import gus06.framework.*;
import java.util.Date;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160805";}


	private Service distance_doubleArray;
	private Service distance_string;
	private Service distance_color;


	public EntityImpl() throws Exception
	{
		distance_doubleArray = Outside.service(this,"gus.math.tabdouble.distance.euclidean");
		distance_string = Outside.service(this,"gus.data.compare.string.comparator1.distance");
		distance_color = Outside.service(this,"gus.awt.color.distance.hsb1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		if(o[0] instanceof Integer && o[1] instanceof Integer)
			return distance((Integer) o[0], (Integer) o[1]);
			
		if(o[0] instanceof Number && o[1] instanceof Number)
			return distance((Number) o[0], (Number) o[1]);
			
		if(o[0] instanceof Date && o[1] instanceof Date)
			return distance((Date) o[0], (Date) o[1]);
			
		if(o[0] instanceof Color && o[1] instanceof Color)
			return distance((Color) o[0], (Color) o[1]);
		
		if(o[0] instanceof double[] && o[1] instanceof double[])
			return distance((double[]) o[0], (double[]) o[1]);
		
		if(o[0] instanceof String && o[1] instanceof String)
			return distance((String) o[0], (String) o[1]);
		
		throw new Exception("Invalid data types: "+o[0].getClass().getName()+" and "+o[1].getClass().getName());
	}
	
	
	
	
	private Integer distance(Integer n1, Integer n2)
	{
		int d1 = n1.intValue();
		int d2 = n2.intValue();
		return new Integer(Math.abs(d1-d2));
	}
	
	private Double distance(Number n1, Number n2)
	{
		double d1 = n1.doubleValue();
		double d2 = n1.doubleValue();
		return new Double(Math.abs(d1-d2));
	}
	
	private Long distance(Date n1, Date n2)
	{
		long t1 = n1.getTime();
		long t2 = n1.getTime();
		return new Long(Math.abs(t1-t2));
	}
	
	private Double distance(Color n1, Color n2) throws Exception
	{
		return (Double) distance_color.t(new Color[]{n1,n2});
	}
	
	private Double distance(double[] n1, double[] n2) throws Exception
	{
		return (Double) distance_doubleArray.t(new Object[]{n1,n2});
	}
	
	private Double distance(String n1, String n2) throws Exception
	{
		return (Double) distance_string.t(new String[]{n1,n2});
	}
}
