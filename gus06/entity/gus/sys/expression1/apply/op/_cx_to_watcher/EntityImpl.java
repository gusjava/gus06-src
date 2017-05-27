package gus06.entity.gus.sys.expression1.apply.op._cx_to_watcher;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170208";}


	private Service getWatcher;
	
	public EntityImpl() throws Exception
	{
		getWatcher = Outside.service(this,"gus.jdbc.connection.builder.watcher");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Connection) return getWatcher.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
