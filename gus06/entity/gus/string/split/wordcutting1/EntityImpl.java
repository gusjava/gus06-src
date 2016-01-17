package gus06.entity.gus.string.split.wordcutting1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150922";}


	private Service normalize;
	private Service splitter;
	
	
	public EntityImpl() throws Exception
	{
		normalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");
		splitter = Outside.service(this,"gus.string.split.words1");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) normalize.t(obj);
		return splitter.t(s);
	}
}
