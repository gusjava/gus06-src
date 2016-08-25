package gus06.entity.gus.file.read.raw;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140929";}


	private Service perform;

	public EntityImpl() throws Exception
	{perform = Outside.service(this,"gus.file.read.raw.j7");}

	public Object t(Object obj) throws Exception
	{return perform.t(obj);}
}
