package gus06.entity.gus.jdbc.gui.sqlquery1.rstostring;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150623";}



	public Object t(Object obj) throws Exception
	{
		ResultSet rs = (ResultSet) obj;
		ResultSetMetaData rsmd = rs.getMetaData();
		int number = rsmd.getColumnCount();
		
		StringBuffer b = new StringBuffer();
		b.append("toString: "+rs.toString()+"\n");
		b.append("resultset type: "+typeToString(rs)+"\n");
		b.append("column number: "+number+"\n\n");
		
		if(number>0)
		{
			for(int i=0;i<number;i++) b.append(rsmd.getColumnName(i+1)+"\t");
			b.append("\n");
			for(int i=0;i<number;i++) b.append(rsmd.getColumnTypeName(i+1)+"\t");
			b.append("\n\n");
			
			while(rs.next())
			{
				for(int i=0;i<number;i++) b.append(getString(rs,i+1)+"\t");
				b.append("\n");
			}
		}
		return b.toString();
	}
	
	
	
	private String getString(ResultSet rs, int col) throws Exception
	{return rs.getString(col);}
	
	
	
	
	private String typeToString(ResultSet rs) throws Exception
	{
		int type = rs.getType();
		if(type==ResultSet.TYPE_FORWARD_ONLY)
			return "TYPE_FORWARD_ONLY";
		if(type==ResultSet.TYPE_SCROLL_INSENSITIVE)
			return "TYPE_SCROLL_INSENSITIVE";
		if(type==ResultSet.TYPE_SCROLL_SENSITIVE)
			return "TYPE_SCROLL_SENSITIVE";
		return "<UNKNOWN TYPE: "+type+">";
	}


}
