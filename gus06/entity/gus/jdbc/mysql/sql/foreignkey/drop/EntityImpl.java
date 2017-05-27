package gus06.entity.gus.jdbc.mysql.sql.foreignkey.drop;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170321";}

	
	private Service format;
	
	public EntityImpl() throws Exception
	{format = Outside.service(this,"gus.jdbc.mysql.format.sql.name");}



	public Object t(Object obj) throws Exception
	{
		String[] o = (String[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String path = o[0];
		String fkName = o[1];
		
		return "ALTER TABLE "+format(path)+" DROP FOREIGN KEY "+fkName;
	}

	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
