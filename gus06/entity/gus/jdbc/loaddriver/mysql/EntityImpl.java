package gus06.entity.gus.jdbc.loaddriver.mysql;

import gus06.framework.*;

public class EntityImpl implements Entity {

	public String creationDate() {return "20141006";}

	public static final String PATH = "com.mysql.jdbc.Driver";

	public EntityImpl() throws Exception
	{
		Outside.service(this,"gus.jdbc.loaddriver").p(PATH);
	}
}
