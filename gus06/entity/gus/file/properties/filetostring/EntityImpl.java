package gus06.entity.gus.file.properties.filetostring;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150620";}


	private Service readFile;
	private Service mapToString;
	
	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.properties");
		mapToString = Outside.service(this,"gus.tostring.map1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) readFile.t(obj);
		return mapToString.t(map);
	}
}
