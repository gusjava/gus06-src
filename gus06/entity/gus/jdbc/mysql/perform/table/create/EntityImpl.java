package gus06.entity.gus.jdbc.mysql.perform.table.create;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150625";}


	private Service buildSql;
	private Service executeSql;
	private Service protectedPath;


	public EntityImpl() throws Exception
	{
		buildSql = Outside.service(this,"gus.jdbc.mysql.sql.table.create");
		executeSql = Outside.service(this,"gus.jdbc.mysql.perform.sqlexecute");
		protectedPath = Outside.service(this,"gus.jdbc.mysql.check.protectedpath");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=7) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		String[] col = (String[]) o[2];
		String[] type = (String[]) o[3];
		String[] primary = (String[]) o[4];
		String[] uniques = (String[]) o[5];
		Object options = o[6];
		
		if(protectedPath.f(path)) throw new Exception("Attempt to create table: "+path);
		
		String sql = (String) buildSql.t(new Object[]{path,col,type,primary,uniques,options});
		executeSql.p(new Object[]{cx,sql});
	}
}
