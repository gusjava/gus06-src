package gus06.entity.gus.dir.listing0.names0.asfilemap;

import java.io.File;
import gus06.framework.*;
import java.util.HashMap;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160628";}


	private Service getName;

	public EntityImpl() throws Exception
	{getName = Outside.service(this,"gus.file.getname0");}


	public Object t(Object obj) throws Exception
	{
		File[] f = toListing(obj);
		
		Map map = new HashMap();
		for(int i=0;i<f.length;i++)
		{
			String name = (String) getName.t(f[i]);
			map.put(name,f[i]);
		}
		return map;
	}
	
	
	
	private File[] toListing(Object obj) throws Exception
	{
		if(obj instanceof File[]) return (File[]) obj;
		if(obj instanceof File) return ((File) obj).listFiles();
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
