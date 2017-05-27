package gus06.entity.gus.jdbc.mysql.perform.fk.clear.db;

import java.sql.Connection;
import java.util.Set;
import java.util.Iterator;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170322";}


	private Service protectedPath;
	private Service tableSet;
	private Service clearTable;


	public EntityImpl() throws Exception
	{
		protectedPath = Outside.service(this,"gus.jdbc.mysql.check.protectedpath");
		tableSet = Outside.service(this,"gus.jdbc.mysql.perform.find.tableset.db");
		clearTable = Outside.service(this,"gus.jdbc.mysql.perform.fk.clear.table");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String dbName = (String) o[1];
		
		if(dbName==null) throw new Exception("Db name is null");
		if(protectedPath.f(dbName)) throw new Exception("Attempt to clear db: "+dbName);
		
		Set tables = (Set) tableSet.t(new Object[]{cx,dbName});
		Iterator it = tables.iterator();
		while(it.hasNext())
		{
			String table = (String) it.next();
			String path = dbName+"."+table;
			clearTable.p(new Object[]{cx,path});
		}
	}
}
