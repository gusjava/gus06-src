package gus06.entity.gus.sys.crypto.pseudo.find.prop_pu;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20141014";}


	private Service prop_pr;

	public EntityImpl() throws Exception
	{prop_pr = Outside.service(this,"gus.sys.crypto.pseudo.find.prop_pr");}
	
	
	public Object g() throws Exception
	{
		Map m = (Map) prop_pr.g();
		if(m==null) return null;
		m.remove("x");
		return m;
	}
}
