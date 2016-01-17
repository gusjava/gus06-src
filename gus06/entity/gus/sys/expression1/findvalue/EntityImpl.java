package gus06.entity.gus.sys.expression1.findvalue;

import gus06.framework.*;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150905";}


	private Service findValue_map;
	private Service findValue_list;


	public EntityImpl() throws Exception
	{
		findValue_map = Outside.service(this,"gus.sys.expression1.findvalue.map");
		findValue_list = Outside.service(this,"gus.sys.expression1.findvalue.list");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object context = o[0];
		
		if(context instanceof Map) return findValue_map.t(obj);
		if(context instanceof List) return findValue_list.t(obj);
		
		throw new Exception("Unsupported context type: "+context.getClass().getName());
	}
}
