package gus06.entity.gus.sys.crypto.pseudo.find.privatekey;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20141015";}


	private Service prop_pr;
	private Service build;

	public EntityImpl() throws Exception
	{
		prop_pr = Outside.service(this,"gus.sys.crypto.pseudo.find.prop_pr");
		build = Outside.service(this,"gus.sys.crypto.pseudo.build.privatekey");
	}
	
	
	public Object g() throws Exception
	{
		Map m = (Map) prop_pr.g();
		if(m==null) return null;
		return build.t(m);
	}
}
