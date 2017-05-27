package gus06.entity.gus.data.perform.putnow;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20170201";}
	
	
	private Service performMap;
	private Service performFile;
	
	public EntityImpl() throws Exception
	{
		performMap = Outside.service(this,"gus.map.putnow");
		performFile = Outside.service(this,"gus.file.properties.perform.field.putnow");
	}


	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		if(o[0] instanceof Map) {performMap.p(o);return;}
		if(o[0] instanceof File) {performFile.p(o);return;}
		throw new Exception("Invalid data type: "+o[0].getClass().getName());
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		if(o[0] instanceof Map) return performMap.t(o);
		throw new Exception("Invalid data type: "+o[0].getClass().getName());
	}
}
