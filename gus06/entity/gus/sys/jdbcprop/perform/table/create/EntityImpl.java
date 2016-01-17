package gus06.entity.gus.sys.jdbcprop.perform.table.create;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150625";}
	
	
	public final static String F_ID = "id";
	public final static String F_VALUE = "value";
	
	public final static String T_ID = "CHAR(100)";
	public final static String T_VALUE = "TEXT";

	

	private Service create;

	public EntityImpl() throws Exception
	{
		create = Outside.service(this,"gus.jdbc.mysql.perform.table.create");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		
		String[] col = new String[]{F_ID,F_VALUE};
		String[] type = new String[]{T_ID,T_VALUE};
		String[] primary = new String[]{F_ID};
		
		create.p(new Object[]{cx,path,col,type,primary});
		return true;
	}
}
