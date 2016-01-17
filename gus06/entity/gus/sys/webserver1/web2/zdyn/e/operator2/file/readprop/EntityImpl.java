package gus06.entity.gus.sys.webserver1.web2.zdyn.e.operator2.file.readprop;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141104";}


	private Service findVar;
	private Service readProp;
	
	public EntityImpl() throws Exception
	{
		findVar = Outside.service(this,"gus.sys.webserver1.web2.zdyn.e.var.build");
		readProp = Outside.service(this,"gus.file.read.properties");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
		
		R mr = (R) o[0];
		String info = (String) o[1];
		Map args = (Map) o[2];
		Map vars = (Map) o[3];
		
		File file = (File) findVar.t(new Object[]{vars,info});
		if(file==null || !file.isFile()) return null;
		
		return readProp.t(file);
	}
}
