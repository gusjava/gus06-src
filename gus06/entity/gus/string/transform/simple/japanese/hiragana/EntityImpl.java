package gus06.entity.gus.string.transform.simple.japanese.hiragana;

import gus06.framework.*;

public class EntityImpl implements Entity, G, T {

	public String creationDate() {return "20170123";}
	
	private String s;
	
	public EntityImpl() throws Exception
	{
		StringBuffer b = new StringBuffer();
		for(int i=12353;i<12436;i++)
		b.append(Character.toChars(i));
		
		s = b.toString();
	}

	
	public Object t(Object obj) throws Exception
	{return s;}
	
	
	public Object g() throws Exception
	{return s;}
}
