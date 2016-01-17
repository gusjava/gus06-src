package gus06.entity.gus.jdbc.mysql.perform.table.truncate.ask;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150625";}
	
	public static final String TITLE = "Empty table";


	private Service truncate;
	private Service dialog;


	public EntityImpl() throws Exception
	{
		truncate = Outside.service(this,"gus.jdbc.mysql.perform.table.truncate");
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
		truncate.p(new Object[]{cx,path});
		return true;
	}
}
