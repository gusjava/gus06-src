package gus06.entity.gus.jdbc.mysql.sql.select.count.where;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161008";}


	
	private Service format;
	
	public EntityImpl() throws Exception
	{format = Outside.service(this,"gus.jdbc.mysql.format.sql.name");}
	
	
		
	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String path = o[0];
		String where = o[1];
		
		return "SELECT COUNT(*) FROM "+format(path)+" WHERE "+where;
	}
	
	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
