package gus06.entity.gus.jdbc.mysql.perform.rows.updatecol.where;

import gus06.framework.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20161020";}

	private Service format;
	
	public EntityImpl() throws Exception
	{format = Outside.service(this,"gus.jdbc.mysql.format.sql.name");}


	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=5) throw new Exception("Wrong data number: "+o.length);
		
		Connection cx = (Connection) o[0];
		String path = (String) o[1];
		String column = (String) o[2];
		Object value = o[3];
		String where = (String) o[4];
		
		String sql = "UPDATE "+format(path)+" SET "+format(column)+"=? WHERE "+where;
		PreparedStatement st = cx.prepareStatement(sql);
		
		st.setObject(1,value);
		st.executeUpdate();
	}
	
	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
