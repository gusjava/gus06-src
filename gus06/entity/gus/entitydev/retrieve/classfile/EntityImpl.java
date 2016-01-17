package gus06.entity.gus.entitydev.retrieve.classfile;

import java.io.File;
import java.util.Map;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140725";}


	private Service nameToPath;

	public EntityImpl() throws Exception
	{nameToPath = Outside.service(this,"entitynametopath");}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) obj;
		
		String entityName = get1(map,SRC.KEY_ENTITYNAME);
		String entityClassPath = (String) nameToPath.t(entityName);
		String relPath = entityClassPath.replace(".",File.separator)+".class";
		
		String rootDir = get1(map,SRC.KEY_ROOTDIR);
		if(!rootDir.endsWith(File.separator)) rootDir += File.separator;
		
		return new File(rootDir+relPath);
	}
	
	
	
	private String get1(Map map, String key) throws Exception
	{
		if(!map.containsKey(key))
			throw new Exception("Key not found inside map: "+key);
		return (String) map.get(key);
	}
}
