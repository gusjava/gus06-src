package gus06.entity.gus.app.prop.submap.display;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140919";}

	// USED BY: gus.debug.init.displaygui
	public static final String ID = "display";

	private Service subMap;

	public EntityImpl() throws Exception
	{subMap = Outside.service(this,"gus.app.prop.submap");}
	
	public Object g() throws Exception
	{return subMap.r(ID);}
}
