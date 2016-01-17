package gus06.entity.gus.jdbc.connection.grants;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150622";}


	private Service findGrants;
	
	public EntityImpl() throws Exception
	{
		findGrants = Outside.service(this,"gus.jdbc.mysql.showgrants");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return findGrants.t(obj);
	}
}
