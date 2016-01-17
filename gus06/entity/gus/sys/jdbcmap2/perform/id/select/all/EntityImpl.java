package gus06.entity.gus.sys.jdbcmap2.perform.id.select.all;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150809";}


	private Service s;

	public EntityImpl() throws Exception
	{s = Outside.service(this,"gus.sys.jdbcmap1.perform.id.select.all");}
	
	public Object t(Object obj) throws Exception
	{return s.t(obj);}
}
