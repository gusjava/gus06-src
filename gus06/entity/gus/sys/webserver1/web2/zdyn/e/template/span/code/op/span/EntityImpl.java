package gus06.entity.gus.sys.webserver1.web2.zdyn.e.template.span.code.op.span;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141007";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map span = (Map) o[0];
		String info = (String) o[1];
		
		if(info.equals("")) return span;
		
		if(!span.containsKey(info))
			throw new Exception("Invalid info: "+info);
		return span.get(info);
	}
}
