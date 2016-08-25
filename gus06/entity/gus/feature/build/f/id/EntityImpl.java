package gus06.entity.gus.feature.build.f.id;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160820";}

	public boolean f(Object obj) throws Exception
	{return ((Boolean) obj).booleanValue();}
}
