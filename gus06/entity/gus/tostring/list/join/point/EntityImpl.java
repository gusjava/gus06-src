package gus06.entity.gus.tostring.list.join.point;

import java.util.List;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150815";}
	
	public static final String DELIM = ".";



	public Object t(Object obj) throws Exception
	{return listToString((List) obj);}
	
	
	
	private String listToString(List list) throws Exception
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<list.size();i++)
		{
			String el = "" + list.get(i);
			if(el.contains(DELIM)) throw new Exception("Invalid element syntax: "+el);
			b.append(el+DELIM);
		}
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
