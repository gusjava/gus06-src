package gus06.entity.gus.clipboard.access.file;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, P, G {

	public String creationDate() {return "20151026";}


	private Service accessListFiles;


	public EntityImpl() throws Exception
	{
		accessListFiles = Outside.service(this,"gus.clipboard.access.listfiles");
	}
	
	
	public void p(Object obj) throws Exception
	{
		accessListFiles.p(obj);
	}

	
	
	public Object g() throws Exception
	{
		List list = (List) accessListFiles.g();
		
		if(list==null) return null;
		if(list.size()!=1) return null;
		return list.get(0);
	}
}
