package gus06.entity.gus.sys.base1.impl.check.map;

import gus06.framework.*;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150803";}


	private Service readMap;

	public EntityImpl() throws Exception
	{
		readMap = Outside.service(this,"gus.sys.base1.impl.read.map");
	}
	
	public boolean f(Object obj) throws Exception
	{
		return readMap.t(obj)!=null;
	}
}
