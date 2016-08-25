package gus06.entity.gus.string.transform.line.each.distinct_n;

import gus06.framework.*;
import java.util.HashSet;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160622";}
	
	public static final String DELIM = "\n";
	
	private Service normalize;
	
	public EntityImpl() throws Exception
	{normalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] nn = s.split(DELIM,-1);
		
		Set set = new HashSet();
		for(String n:nn)
		{
			String a = format(n);
			if(set.contains(a)) return "false";
			set.add(a);
		}
		return "true";
	}
	
	private String format(String s) throws Exception
	{return (String) normalize.t(s);}
}
