package gus06.entity.gus.entitydev.retrieve.jarfile1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140730";}


	private Service retrieve;
	private File rootDir;
	
	public EntityImpl() throws Exception
	{
		retrieve = Outside.service(this,"gus.entitydev.retrieve.jarfile");
		rootDir = (File) Outside.resource(this,"entityjardir");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = toMap(obj);
		
		if(rootDir==null)
			throw new Exception("Unknown root path for entity jar");
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
