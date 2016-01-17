package gus06.entity.gus.jdbc.connection.grants.display;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150613";}


	private Service findGrants;
	
	public EntityImpl() throws Exception
	{
		findGrants = Outside.service(this,"gus.jdbc.connection.grants");
	}


	public Object t(Object obj) throws Exception
	{
		String grants = (String) findGrants.t(obj);

		if(grants==null || grants.equals("")) return "";
		if(grants.endsWith("*"))
		{
			String userName = grants.substring(0,grants.length()-1);
			return "LOGIN1_root#"+userName;
		}
		return "LOGIN1_user#"+grants;
	}
}
