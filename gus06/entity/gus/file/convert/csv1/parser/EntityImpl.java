package gus06.entity.gus.file.convert.csv1.parser;

import gus06.framework.*;

public class EntityImpl implements Entity, T
{
	public String creationDate() {return "20150702";}
	
	public static char CHAR_DELIM = ';';

	private Parser1 parser;
	
	public EntityImpl()
	{parser = new Parser1(CHAR_DELIM);}
	
	public Object t(Object obj) throws Exception
	{return parser.parse((String) obj);}
}