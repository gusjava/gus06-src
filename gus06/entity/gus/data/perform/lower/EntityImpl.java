package gus06.entity.gus.data.perform.lower;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160818";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof List) return perform((List) obj);
		if(obj instanceof Set) return perform((Set) obj);
		if(obj instanceof String[]) return perform((String[]) obj);
		if(obj instanceof String) return perform((String) obj);
		if(obj instanceof Number) return perform(""+obj);
		if(obj instanceof Boolean) return perform(""+obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private String perform(String s)
	{
		return s.toLowerCase();
	}
	
	private String[] perform(String[] a)
	{
		String[] a1 = new String[a.length];
		for(int i=0;i<a1.length;i++) a1[i] = perform(a[i]);
		return a1;
	}
	
	private List perform(List l)
	{
		List l1 = new ArrayList();
		for(Object o:l) l1.add(perform(""+o));
		return l1;
	}
	
	private Set perform(Set s)
	{
		Set s1 = new HashSet();
		for(Object o:s) s1.add(perform(""+o));
		return s1;
	}
}
