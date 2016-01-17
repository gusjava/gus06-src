package gus06.entity.gus.clipboard.access.listfiles.first;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20151009";}


	private Service clipboard;
	
	
	public EntityImpl() throws Exception
	{clipboard = Outside.service(this,"gus.clipboard.access.listfiles");}


	public Object g() throws Exception
	{
		List list = (List) clipboard.g();
		if(list==null || list.isEmpty()) return null;
		return list.get(0);
	}
}
