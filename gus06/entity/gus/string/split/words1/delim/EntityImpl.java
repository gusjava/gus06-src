package gus06.entity.gus.string.split.words1.delim;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160503";}

	public static String DELIM = "\"`'�\\ \n\r\t/[](){}<>|!?:.,;=_-+*%@#&$���^�";
	
	public Object g() throws Exception
	{return DELIM;}
}