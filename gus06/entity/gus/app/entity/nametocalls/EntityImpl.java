package gus06.entity.gus.app.entity.nametocalls;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140827";}


	private Service retrieveSrcCode;
	private Service extractSer;
	private Service extractRes;
	
	
	public EntityImpl() throws Exception
	{
		retrieveSrcCode = Outside.service(this,"gus.entitydev.retrieve.srccode1");
		extractSer = Outside.service(this,"gus.java.srccode.extract.entity.calls.service");
		extractRes = Outside.service(this,"gus.java.srccode.extract.entity.calls.resource");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		String entityName = (String) obj;
		String src = (String) retrieveSrcCode.t(entityName);
		
		List services = (List) extractSer.t(src);
		List resources = (List) extractRes.t(src);
		
		List calls = new ArrayList();
		calls.addAll(services);
		calls.addAll(resources);
		
		return calls;
	}
}
