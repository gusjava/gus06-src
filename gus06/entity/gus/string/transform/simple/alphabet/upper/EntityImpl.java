package gus06.entity.gus.string.transform.simple.alphabet.upper;

import gus06.framework.*;

public class EntityImpl implements Entity, G, T {

	public String creationDate() {return "20150926";}
	
	public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Object t(Object obj) throws Exception
	{return ALPHABET;}
	
	public Object g() throws Exception
	{return ALPHABET;}
}
