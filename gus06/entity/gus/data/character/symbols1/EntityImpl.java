package gus06.entity.gus.data.character.symbols1;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160817";}

	public static String DELIM = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~£¤§¨°µ€";
	
	public Object g() throws Exception
	{return DELIM;}
}