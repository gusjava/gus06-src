package gus06.entity.gus.string.transform.line.remove.doubloon_n;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160620";}
	
	public static final String DELIM = "\n";
	
	private Service normalize;
	
	public EntityImpl() throws Exception
	{normalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");}
	
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split(DELIM,-1);
		
		StringBuffer b = new StringBuffer();
		HashSet set = new HashSet();
		
		for(int i=0;i<n.length;i++)
		{
			String a = format(n[i]);
			if(!set.contains(a))
			{
			    set.add(a);
			    b.append(n[i]+DELIM);
			}
		}
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	private String format(String s) throws Exception
	{return (String) normalize.t(s);}
}
