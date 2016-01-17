package gus06.entity.gus.string.transform.app.entity.srccode;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151101";}


	private Service findSrc;


	public EntityImpl() throws Exception
	{
		findSrc = Outside.service(this,"gus.app.jarfile.entity.findsrc");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		return findSrc.t(entityName);
	}
}
