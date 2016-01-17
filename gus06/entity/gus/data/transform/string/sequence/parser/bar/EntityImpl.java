package gus06.entity.gus.data.transform.string.sequence.parser.bar;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}

	public static final String DELIM = "|";


	private Service parserBuilder;
	private T parser;
	
	public EntityImpl() throws Exception
	{
		parserBuilder = Outside.service(this,"gus.data.transform.string.sequence.parser");
		parser = (T) parserBuilder.t(DELIM);
	}

	public Object t(Object obj) throws Exception
	{return parser.t(obj);}
}