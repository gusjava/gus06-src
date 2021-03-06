package gus06.entity.gus.jdbc.mysql.perform.user.drop.ask;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150625";}
	


	private Service drop;
	private Service dialog;


	public EntityImpl() throws Exception
	{
		drop = Outside.service(this,"gus.jdbc.mysql.perform.db.drop");
		dialog = Outside.service(this,"gus.input.confirm.dialog");
	}
	
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String name = (String) o[1];
		
		String[] n = name.split("@");
		String user = n[0];
		String host = n[1];
		
		
		boolean ok = dialog.f("Delete user ?");
		if(!ok) return false;
		
		drop.p(new Object[]{cx,user,host});
		return true;
	}
}
