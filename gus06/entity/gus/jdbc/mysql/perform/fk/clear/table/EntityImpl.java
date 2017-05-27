package gus06.entity.gus.jdbc.mysql.perform.fk.clear.table;

import java.sql.Connection;
import java.util.Set;
import java.util.Iterator;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170322";}


	private Service fkList;


	public EntityImpl() throws Exception
	{
		fkList = Outside.service(this,"gus.jdbc.mysql.perform.find.tableset.db");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		
		
	}
}
