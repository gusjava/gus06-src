package gus06.entity.gus.string.transform.sequence.count.multiple_n;

import gus06.framework.*;
import java.util.HashSet;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160620";}
	
	public static final String DELIM = ";";
	
	private Service normalize;
	
	public EntityImpl() throws Exception
	{normalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] nn = s.split(DELIM,-1);
		
		Set set1 = new HashSet();
		Set set2 = new HashSet();
		
		for(String n:nn)
		{
			String a = format(n);
			if(!set1.contains(a)) set1.add(a);
			else if(!set2.contains(a)) set2.add(a);
		}
		
		return ""+set2.size();
	}
	
	private String format(String s) throws Exception
	{return (String) normalize.t(s);}
}
