package gus06.entity.gus.sys.script1.build.gg;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170320";}


	private Service script_to_g;

	public EntityImpl() throws Exception
	{
		script_to_g = Outside.service(this,"gus.sys.script1.build.g");
	}
	
	public Object t(Object obj) throws Exception
	{
		G g = (G) script_to_g.t(obj);
		return g.g();
	}
}
