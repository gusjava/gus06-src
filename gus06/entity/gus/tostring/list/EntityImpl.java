package gus06.entity.gus.tostring.list;

import java.util.List;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150527";}



	public Object t(Object obj) throws Exception
	{return listToString((List) obj);}
	
	
	
	private String listToString(List list) throws Exception
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<list.size();i++)
		{
			String el = (String) list.get(i);
			if(el.contains("\n")) throw new Exception("Invalid element syntax: "+el);
			b.append(el+"\n");
		}
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
