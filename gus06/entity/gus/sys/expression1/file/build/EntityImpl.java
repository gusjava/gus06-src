package gus06.entity.gus.sys.expression1.file.build;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170310";}


	private Service currentDir;
	private Service currentDir0;


	public EntityImpl() throws Exception
	{
		currentDir = Outside.service(this,"gus.sys.script1.access.opmap.script.dir");
		currentDir0 = Outside.service(this,"gus.system.prop.userdir.modify");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String path = (String) o[0];
		Map opMap = (Map) o[1];
		
		File f = new File(path);
		if(f.isAbsolute()) return f.getCanonicalFile();
		
		File dir = (File) currentDir.t(opMap);
		if(dir==null) dir = (File) currentDir0.g();
		
		return new File(dir,path).getCanonicalFile();
	}
}
