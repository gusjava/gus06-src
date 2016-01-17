package gus06.entity.gus.app.restart1.clearlauncher;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150626";}
	
	public static final String LAUNCHER = "launcher";



	private Service delete;
	private Map params;
	
	public EntityImpl() throws Exception
	{
		delete = Outside.service(this,"gus.file.op.delete");
		params = (Map) Outside.resource(this,"params");
	}

	

	public void e() throws Exception
	{
		if(!params.containsKey(LAUNCHER)) return;
		
		String path = (String) params.get(LAUNCHER);
		File file = new File(path);
		
		if(!file.exists()) return;
		delete.p(file);
	}
}
