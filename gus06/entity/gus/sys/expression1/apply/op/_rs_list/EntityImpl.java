package gus06.entity.gus.sys.expression1.apply.op._rs_list;

import gus06.framework.*;
import java.sql.ResultSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160309";}


	private Service toObjectMapList;
	
	public EntityImpl() throws Exception
	{
		toObjectMapList = Outside.service(this,"gus.jdbc.resultset.toobjectmaplist");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof ResultSet) return toObjectMapList.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
