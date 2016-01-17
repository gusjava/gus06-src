package gus06.entity.gus.filter.string.build.number.equals;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150529";}


	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String)obj;
		Double value = toDouble(s);
		return new F_equals(value);
	}
	
	
	private class F_equals implements F
	{
		private Double value;
		public F_equals(Double value)
		{this.value = value;}

		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			if(value==null) return false;
			String str = obj.toString();

			Double v = toDouble(str);
			if(v==null) return false;
			return v.doubleValue()==value.doubleValue();
		}
	}


	
	

	private Double toDouble(String s)
	{
		if(s==null) return null;
		s = s.replace(" ","").replace("+","");		
		try{
			double d = Double.parseDouble(s);
			return new Double(d);
		}
		catch(Exception e)
		{return null;}
	}
}
