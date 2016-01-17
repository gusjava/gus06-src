package gus06.entity.gus.sys.webserver1.web2.zdyn.e.template.span.code.op.set;

import gus06.framework.*;
import java.util.Map;
import java.util.HashSet;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141007";}
	
	
	private Service toList;
	
	public EntityImpl() throws Exception
	{
		toList = Outside.service(this,"gus.list.string.stringtolist.builder2");
	}
	
		
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map span = (Map) o[0];
		String info = (String) o[1];
		
		return new HashSet((List) toList.t(info));
	}
}
