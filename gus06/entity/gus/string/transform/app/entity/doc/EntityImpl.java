package gus06.entity.gus.string.transform.app.entity.doc;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160508";}


	private Service findLingString;


	public EntityImpl() throws Exception
	{
		findLingString = Outside.service(this,"gus.ling.find.lingstring");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		return findLingString.r("doc_"+entityName);
	}
}
