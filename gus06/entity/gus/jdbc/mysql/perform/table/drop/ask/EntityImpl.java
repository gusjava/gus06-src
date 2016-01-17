package gus06.entity.gus.jdbc.mysql.perform.table.drop.ask;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150625";}
	
	public static final String TITLE = "Remove table";


	private Service drop;
	private Service dialog;


	public EntityImpl() throws Exception
	{
		drop = Outside.service(this,"gus.jdbc.mysql.perform.table.drop");
		dialog = Outside.service(this,"gus.input.confirm.dialog");
	}
	
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String dbName = (String) o[1];
		String tableName = (String) o[2];
		
		boolean ok = dialog.f(TITLE);
		if(!ok) return false;
		
		String path = dbName+"."+tableName;
		drop.p(new Object[]{cx,path});
		return true;
	}
}
