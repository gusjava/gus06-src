package gus06.entity.gus.jdbc.mysql.perform.row.update2;

import gus06.framework.*;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160405";}


	private Service updateRow;
	private Service findPrimary;
	
	public EntityImpl() throws Exception
	{
		updateRow = Outside.service(this,"gus.jdbc.mysql.perform.row.update");
		findPrimary = Outside.service(this,"gus.jdbc.mysql.perform.table.findprimarykeys");
	}


	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		Map map = (Map) o[2];
		
		Set pkeys = (Set) findPrimary.t(new Object[]{cx,path});
		updateRow.p(new Object[]{cx,path,map,pkeys});
	}
}
