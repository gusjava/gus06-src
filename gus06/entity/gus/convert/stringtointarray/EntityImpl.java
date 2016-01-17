package gus06.entity.gus.convert.stringtointarray;

import gus06.framework.*;
import java.awt.Dimension;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140912";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		return array((String) obj);
	}
	
	
	private int[] array(String s)
	{
		String[] n = s.split(" ");
		int[] a = new int[n.length];
		for(int i=0;i<n.length;i++) a[i] = i_(n[i]);
		return a;
	}


	private int i_(String s)
	{return Integer.parseInt(s);}
}
