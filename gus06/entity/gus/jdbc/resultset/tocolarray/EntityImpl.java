package gus06.entity.gus.jdbc.resultset.tocolarray;

import gus06.framework.*;
import java.sql.ResultSet;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150625";}


	private Service getColArray;
	
	public EntityImpl() throws Exception
	{getColArray = Outside.service(this,"gus.jdbc.resultset.get.colarray");}


	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) obj;
		String[] col = (String[]) getColArray.t(rs);
		rs.close();
		return col;
	}
}
