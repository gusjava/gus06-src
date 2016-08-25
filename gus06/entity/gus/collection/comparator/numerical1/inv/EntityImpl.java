package gus06.entity.gus.collection.comparator.numerical1.inv;

import gus06.framework.*;
import java.util.Comparator;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160804";}


	private Service extractDouble;

	private Comparator comparator = new Comparator1();

	public EntityImpl() throws Exception
	{
		extractDouble = Outside.service(this,"gus.string.extract.double1.f");
	}
	
	
	public Object g() throws Exception
	{return comparator;}
	
	
	// A OPTIMISER AVEC UN CACHE
	private class Comparator1 implements Comparator
	{
		public int compare(Object o1, Object o2)
		{
			Double d1 = extract((String) o1);
			Double d2 = extract((String) o2);
			
			return d2.compareTo(d1);
		}
	}
		
	
	private Double extract(String s)
	{
		try
		{
			Double d = (Double) extractDouble.t(s);
			return d!=null ? d : new Double(0);
		}
		catch(Exception e)
		{return new Double(0);}
	}
}
