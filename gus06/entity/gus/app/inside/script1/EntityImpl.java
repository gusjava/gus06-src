package gus06.entity.gus.app.inside.script1;

import gus06.framework.*;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20170401";}


	private Service inside;
	
	public EntityImpl() throws Exception
	{inside = Outside.service(this,"gus.app.inside.script");}
	
	
	public Object t(Object obj) throws Exception
	{
		String id = (String) obj;
		if(!id.endsWith(".gus")) id = id+".gus";
		return inside.t(id);
	}
	
	public Object r(String key) throws Exception
	{return t(key);}
}
