package gus06.entity.gus.string.transform.words.count;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150926";}


	private Service split;



	public EntityImpl() throws Exception
	{
		split = Outside.service(this,"gus.string.split.words1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String[] n = (String[]) split.t(obj);
		return ""+n.length;
	}
}
