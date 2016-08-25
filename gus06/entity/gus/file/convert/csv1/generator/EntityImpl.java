package gus06.entity.gus.file.convert.csv1.generator;

import gus06.framework.*;

public class EntityImpl implements Entity, T
{
	public String creationDate() {return "20150702";}
	
	public static final char CHAR_DELIM = ';';

	private Generator1 generator;
	
	public EntityImpl()
	{generator = new Generator1(CHAR_DELIM);}
	
	public Object t(Object obj) throws Exception
	{return generator.generate((String[][])obj);}
}