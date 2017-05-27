package gus06.entity.gus.tostring.array.join.semicolon;

import java.util.List;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170518";}
	
	public static final String DELIM = ";";



	public Object t(Object obj) throws Exception
	{return arrayToString((Object[]) obj);}
	
	
	
	private String arrayToString(Object[] array) throws Exception
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<array.length;i++)
		{
			String el = "" + array[i];
			if(el.contains(DELIM)) throw new Exception("Invalid element syntax: "+el);
			b.append(el+DELIM);
		}
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
