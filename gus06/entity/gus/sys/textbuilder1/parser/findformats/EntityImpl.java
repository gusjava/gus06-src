package gus06.entity.gus.sys.textbuilder1.parser.findformats;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160302";}
	
	public static final String START = "format.";


	private Service subMap;


	public EntityImpl() throws Exception
	{
		subMap = Outside.service(this,"gus.map.string.submap");
	}
	
	public Object t(Object obj) throws Exception
	{
		return subMap.t(new Object[]{obj,START});
	}
}
