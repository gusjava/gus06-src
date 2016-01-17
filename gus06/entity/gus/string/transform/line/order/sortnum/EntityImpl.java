package gus06.entity.gus.string.transform.line.order.sortnum;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141114";}
	
	public static final String DELIM = "\n";
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split(DELIM,-1);
		
		Arrays.sort(n,comparator);
		
		StringBuffer b = new StringBuffer();
		for(int i=0;i<n.length;i++)
		b.append(n[i]+DELIM);
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	
	private static Comparator comparator = new Comparator() {
		public int compare(Object o1, Object o2)
		{
			Double d1 = toDouble((String) o1);
			Double d2 = toDouble((String) o2);
			return d1.compareTo(d2);
		}};
		
	
	private static Double toDouble(String s)
	{
		String[] n = s.split("[\t ]+");
		try{return new Double(n[0]);}
		catch(NumberFormatException e)
		{return new Double(0);}
	}
}
