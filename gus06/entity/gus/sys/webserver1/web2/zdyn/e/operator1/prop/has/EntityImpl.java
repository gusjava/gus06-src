package gus06.entity.gus.sys.webserver1.web2.zdyn.e.operator1.prop.has;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141026";}


	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		R mr = (R) o[0];
		String info = (String) o[1];
		
		Map prop = (Map) mr.r("data config prop");
		return ""+prop.containsKey(info);
	}
}
