package gus06.entity.gus.string.split.words1._delim;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20160505";}

	public static String DELIM = "\"`'Ф\\ \n\r\t/[](){}<>|!?:.,;=-+*%@#&$згд^и";
	
	public Object g() throws Exception
	{return DELIM;}
}