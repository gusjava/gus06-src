package gus06.entity.gus.sys.expression1.findvalue.list;

import gus06.framework.*;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150905";}


	private Service findValue;


	public EntityImpl() throws Exception
	{
		findValue = Outside.service(this,"gus.sys.expression1.findvalue.map");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List list = (List) o[0];
		String path = (String) o[1];
		
		int size = list.size();
		for(int i=size-1;i>=0;i--)
		{
			Map map = (Map) list.get(i);
			Object r = findValue.t(new Object[]{map,path});
			if(r!=null) return r;
		}
		return null;
	}
}
