package gus06.entity.gus.sys.script1.access.tag.type1.isroot;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160326";}
	
	public static final String ROOT = "root";


	private Service getType;


	public EntityImpl() throws Exception
	{
		getType = Outside.service(this,"gus.sys.script1.access.tag.type1");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		String type = (String) getType.t(obj);
		return type.equals(ROOT);
	}
}
