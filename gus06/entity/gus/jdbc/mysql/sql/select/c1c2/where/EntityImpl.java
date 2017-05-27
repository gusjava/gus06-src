package gus06.entity.gus.jdbc.mysql.sql.select.c1c2.where;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170517";}


	
	private Service format;
	
	public EntityImpl() throws Exception
	{format = Outside.service(this,"gus.jdbc.mysql.format.sql.name");}
	
	
		
	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
		
		String path = (String) o[0];
		String c1 = (String) o[1];
		String c2 = (String) o[2];
		String where = o[3];
		
		return "SELECT "+format(c1)+","+format(c2)+" FROM "+format(path)+" WHERE "+where;
	}
	
	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
