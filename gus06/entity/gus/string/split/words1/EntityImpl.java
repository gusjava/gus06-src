package gus06.entity.gus.string.split.words1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141105";}
	

	private Service quote;
	private Service delim;
	
	private String regex;
	
	public EntityImpl() throws Exception
	{
		quote = Outside.service(this,"gus.string.transform.regexp.quote");
		delim = Outside.service(this,"gus.string.split.words1.delim");
		
		regex = "["+quote.t(delim.g())+"]+";
	}

	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		return s.split(regex);
	}
}
