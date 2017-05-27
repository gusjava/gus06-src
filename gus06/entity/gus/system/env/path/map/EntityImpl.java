package gus06.entity.gus.system.env.path.map;

import gus06.framework.*;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.io.FileFilter;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20170312";}
	
	public static final FileFilter FILTER = new FileFilter() {
		public boolean accept(File f)
		{
			if(!f.isFile()) return false;
			String name = f.getName().toLowerCase();
			return name.endsWith(".exe") || name.endsWith(".cmd") || name.endsWith(".bat");
		}
	};


	private Service getFiles;
	private Service getName;

	public EntityImpl() throws Exception
	{
		getFiles = Outside.service(this,"gus.system.env.path.files");
		getName = Outside.service(this,"gus.file.getname0");
	}

	
	
	public Object g() throws Exception
	{
		File[] ff = (File[]) getFiles.g();
		Map map = new HashMap();
		
		for(File f:ff)
		{
			File[] files = f.listFiles(FILTER);
			if(files!=null) for(File file:files)
			{
				String name = (String) getName.t(file);
				map.put(name,file);
			}
		}
		
		return map;
	}
}
