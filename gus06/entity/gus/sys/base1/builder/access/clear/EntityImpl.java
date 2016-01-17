package gus06.entity.gus.sys.base1.builder.access.clear;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150807";}


	private Service clearFile;
	private Service clearMap;
	
	public EntityImpl() throws Exception
	{
		clearFile = Outside.service(this,"gus.dir.op.empty");
		clearMap = Outside.service(this,"gus.sys.base1.impl.clear.map");
	}
	
	
	public void p(Object obj) throws Exception
	{
		G g = (G) obj;
		
		Object base = g.g();
		if(base instanceof File) {clearFile.p(base);return;}
		if(base instanceof Map) {clearMap.p(base);return;}
		
		throw new Exception("Unsupported base class: "+base.getClass().getName());
	}
}
