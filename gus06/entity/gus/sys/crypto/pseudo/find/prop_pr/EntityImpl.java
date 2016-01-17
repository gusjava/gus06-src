package gus06.entity.gus.sys.crypto.pseudo.find.prop_pr;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20141014";}


	private Service getFile;
	private Service readFile;


	public EntityImpl() throws Exception
	{
		getFile = Outside.service(this,"gus.sys.crypto.pseudo.getfile");
		readFile = Outside.service(this,"gus.file.read.properties");
	}
	
	
	public Object g() throws Exception
	{
		File file = (File) getFile.g();
		if(file==null || !file.exists()) return null;
		
		Map m = (Map) readFile.t(file);
		String owner = get(m,"owner");
		String name = file.getName();
		
		if(!name.startsWith(owner+"."))
			throw new Exception("Wrong file name for owner "+owner+" : "+name);
		return m;
	}
	
	
	
	private String get(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) throw new Exception("Key not found: "+key);
		return (String) map.get(key);
	}
}
