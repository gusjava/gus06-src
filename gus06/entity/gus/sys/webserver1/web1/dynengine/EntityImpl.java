package gus06.entity.gus.sys.webserver1.web1.dynengine;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140929";}


	private Service enginePHP;
	private Service engineJSP;


	public EntityImpl() throws Exception
	{
		enginePHP = Outside.service(this,"gus.sys.webserver1.web1.dynengine.php");
		engineJSP = Outside.service(this,"gus.sys.webserver1.web1.dynengine.jsp");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String type = (String) obj;
		if(type.equals("php")) return enginePHP;
		if(type.equals("jsp")) return engineJSP;
		return null;
	}
}
