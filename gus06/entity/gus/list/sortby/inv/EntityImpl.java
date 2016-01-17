package gus06.entity.gus.list.sortby.inv;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151117";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List input = (List) o[0];
		T trans = (T) o[1];
		
		List output = new ArrayList(input);
		Collections.sort(output,new Comparator1(trans));
		return output;
	}
	
	
	private class Comparator1 implements Comparator
	{
		private T t;
		public Comparator1(T t) {this.t = t;}
		
		public int compare(Object o1, Object o2)
		{
			Comparable r1 = (Comparable) trans(t,o1);
			Comparable r2 = (Comparable) trans(t,o2);
			
			if(r1==null || r2==null) 
				return ((Comparable) o2).compareTo((Comparable) o1);
			return r2.compareTo(r1);
		}
	}
	
	
	
	private Object trans(T t, Object o)
	{
		try{return t.t(o);}
		catch(Exception e)
		{Outside.err(this,"trans(T,Object)",e);}
		return null;
	}
}
