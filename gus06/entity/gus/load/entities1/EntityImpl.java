package gus06.entity.gus.load.entities1;

import gus06.framework.*;

public class EntityImpl implements Entity {

	public String creationDate() {return "20151026";}


	public EntityImpl() throws Exception
	{
		Outside.service(this,"gus.beep");
		Outside.service(this,"gus.beep.sleep1000");
		
		Outside.service(this,"gus.sys.clipboard1.g.file");
		Outside.service(this,"gus.collection.filter.build");
		
		Outside.service(this,"gus.system.prop.access");
		Outside.service(this,"gus.system.env.access");
		
		Outside.service(this,"gus.sys.parser3.builder1.f");
		Outside.service(this,"gus.sys.parser3.builder1.t");
		Outside.service(this,"gus.sys.parser3.builder1.h");
	}
}