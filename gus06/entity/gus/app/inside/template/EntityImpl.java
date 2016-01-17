package gus06.entity.gus.app.inside.template;

import gus06.framework.*;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20140905";}


	private Service inside;
	
	public EntityImpl() throws Exception
	{inside = Outside.service(this,"inside");}
	
	
	public Object t(Object obj) throws Exception
	{
		String id = (String) obj;
		String path = "template/"+id;
		return inside.t("txt."+path);
	}
	
	public Object r(String key) throws Exception
	{return t(key);}
}
