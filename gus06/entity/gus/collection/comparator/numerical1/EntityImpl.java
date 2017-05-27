package gus06.entity.gus.collection.comparator.numerical1;

import gus06.framework.*;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160804";}


	private Service extractDouble;

	private Comparator comparator = new Comparator1();

	public EntityImpl() throws Exception
	{
		extractDouble = Outside.service(this,"gus.string.extract.double1.a");
	}
	
	
	public Object g() throws Exception
	{return comparator;}
	
	
	// A OPTIMISER AVEC UN CACHE
	private class Comparator1 implements Comparator
	{
		public int compare(Object o1, Object o2)
		{
			List l1 = extract((String) o1);
			List l2 = extract((String) o2);
			
			Double d1 = next(l1);
			Double d2 = next(l2);
			int r = d1.compareTo(d2);
			
			while(r==0 && (!l1.isEmpty() || !l2.isEmpty()))
			{
				d1 = next(l1);
				d2 = next(l2);
				r = d1.compareTo(d2);
			}
			return r;
		}
	}
		
	
	private List extract(String s)
	{
		try{return (List) extractDouble.t(s);}
		catch(Exception e)
		{return new ArrayList();}
	}
	
	private Double next(List l)
	{
		if(l.isEmpty()) return Double.valueOf(0);
		return (Double) l.remove(0);
	}
}
