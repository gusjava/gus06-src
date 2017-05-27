package gus06.entity.gus.data.perform.eachvalue;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160412";}
	
	
	private Service performMap;
	private Service performFile;
	
	public EntityImpl() throws Exception
	{
		performMap = Outside.service(this,"gus.map.value.each");
		performFile = Outside.service(this,"gus.dirfile.perform.eachvalue.handle");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof Map)
		{
			performMap.p(obj);
			return;
		}
		
		if(input instanceof File)
		{
			performFile.p(obj);
			return;
		}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
