package gus06.entity.gus.sys.crypto.pseudo.find.publickey;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20141015";}


	private Service prop_pu;
	private Service build;

	public EntityImpl() throws Exception
	{
		prop_pu = Outside.service(this,"gus.sys.crypto.pseudo.find.prop_pu");
		build = Outside.service(this,"gus.sys.crypto.pseudo.build.publickey1");
	}
	
	
	public Object g() throws Exception
	{
		Map m = (Map) prop_pu.g();
		if(m==null) return null;
		return build.t(m);
	}
}
