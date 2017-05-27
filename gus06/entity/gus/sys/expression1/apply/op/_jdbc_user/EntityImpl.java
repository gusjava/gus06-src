package gus06.entity.gus.sys.expression1.apply.op._jdbc_user;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161101";}


	private Service find;
	
	public EntityImpl() throws Exception
	{
		find = Outside.service(this,"gus.jdbc.mysql.perform.find.user.current");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Connection) return find.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
