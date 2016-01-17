package gus06.entity.gus.entitydev.retrieve.javafile1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140724";}



	private Service retrieve;
	private File rootDir;
	
	public EntityImpl() throws Exception
	{
		retrieve = Outside.service(this,"gus.entitydev.retrieve.javafile");
		rootDir = (File) Outside.resource(this,"path#path.dev.entityroot");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = toMap(obj);
		
		if(rootDir==null)
			throw new Exception("Unknown root path for entity src code");
		map.put(SRC.KEY_ROOTDIR,rootDir.getAbsolutePath());
		
		return retrieve.t(map);
	}
	
	
	
	
	private Map toMap(Object obj) throws Exception
	{
		if(obj instanceof Map) return (Map) obj;
		if(obj instanceof String)
		{
			Map map = new HashMap();
			map.put(SRC.KEY_ENTITYNAME,obj);
			return map;
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
