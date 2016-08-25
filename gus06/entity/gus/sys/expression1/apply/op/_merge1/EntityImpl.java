package gus06.entity.gus.sys.expression1.apply.op._merge1;

import gus06.framework.*;
import java.util.Set;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160227";}


	private Service merge1;
	
	
	public EntityImpl() throws Exception
	{
		merge1 = Outside.service(this,"gus.map.maparray.merge.engine1");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Map[]) return merge1.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
