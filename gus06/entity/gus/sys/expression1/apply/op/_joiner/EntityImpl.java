package gus06.entity.gus.sys.expression1.apply.op._joiner;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160921";}


	private Service perform;
	private Service fromList;


	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.data.perform.joiner");
		fromList = Outside.service(this,"gus.convert.listtostringarray");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String[]) return perform.t(obj);
		if(obj instanceof List) return perform.t(fromList.t(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
