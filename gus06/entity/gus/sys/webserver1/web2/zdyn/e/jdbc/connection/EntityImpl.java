package gus06.entity.gus.sys.webserver1.web2.zdyn.e.jdbc.connection;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141007";}

	public static final String PATH = "data cx";


	private Service buildCx;



	public EntityImpl() throws Exception
	{
		buildCx = Outside.service(this,"gus.sys.webserver1.web2.zdyn.e.jdbc.connection.build");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(!((F) obj).f(PATH))
			((V) obj).v(PATH,buildCx.t(obj));
		return ((R) obj).r(PATH);
	}
}
