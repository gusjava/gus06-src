package gus06.entity.gus.sys.expression1.apply.op._rs_map;

import gus06.framework.*;
import java.sql.ResultSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160309";}


	private Service toObjectMapMap;
	
	public EntityImpl() throws Exception
	{
		toObjectMapMap = Outside.service(this,"gus.jdbc.resultset.toobjectmapmap");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof ResultSet) return toObjectMapMap.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
