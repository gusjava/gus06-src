package gus06.entity.gus.math.function.build.polynomial;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151129";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof int[]) return new H1((int[]) obj);
		if(obj instanceof double[]) return new H2((double[]) obj);
		if(obj instanceof List) return new H3((List) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class H1 implements H
	{
		private int[] coef;
		public H1(int[] coef) {this.coef = coef;}
		
		public double h(double value)
		{
			double sum = 0;
			for(int i=0;i<coef.length;i++)
				sum += coef[i] * Math.pow(value,i);
			return sum;
		}
	}
	
	
	private class H2 implements H
	{
		private double[] coef;
		public H2(double[] coef) {this.coef = coef;}
		
		public double h(double value)
		{
			double sum = 0;
			for(int i=0;i<coef.length;i++)
				sum += coef[i] * Math.pow(value,i);
			return sum;
		}
	}
	
	
	private class H3 implements H
	{
		private List coef;
		public H3(List coef) {this.coef = coef;}
		
		public double h(double value)
		{
			double sum = 0;
			for(int i=0;i<coef.size();i++)
			{
				Number c = (Number) coef.get(i);
				sum += c.doubleValue() * Math.pow(value,i);
			}
			return sum;
		}
	}
}
