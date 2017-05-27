package gus06.entity.gus.data.perform.collectvalue;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20161115";}
	
	
	private Service performFile;
	private Service performMap;
	
	public EntityImpl() throws Exception
	{
		performFile = Outside.service(this,"gus.dirfile.perform.eachvalue.transform");
		performMap = Outside.service(this,"gus.map.value.collect");
	}
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof Map) 	{performMap.p(obj);return;}
		if(input instanceof File) 	{performFile.p(obj);return;}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof Map) return performMap.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
