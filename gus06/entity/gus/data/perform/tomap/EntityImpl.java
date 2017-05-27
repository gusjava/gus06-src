package gus06.entity.gus.data.perform.tomap;

import gus06.framework.*;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170327";}


	private Service rToMap;
	private Service tToMap;
	private Service fromList;
	private Service fromSet;
	private Service fromArray;
	private Service fromString;
	private Service fromFile;
	
	
	public EntityImpl() throws Exception
	{
		rToMap = Outside.service(this,"gus.convert.rtomap");
		tToMap = Outside.service(this,"gus.convert.ttomap");
		fromList = Outside.service(this,"gus.map.build.fromlist");
		fromSet = Outside.service(this,"gus.map.build.fromset");
		fromArray = Outside.service(this,"gus.map.build.fromarray");
		fromString = Outside.service(this,"gus.convert.stringtomap");
		fromFile = Outside.service(this,"gus.file.read.properties.generic");
	}

	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		if(obj instanceof Map) return obj;
		if(obj instanceof Set) return fromSet.t(obj);
		if(obj instanceof List) return fromList.t(obj);
		if(obj instanceof Object[]) return fromArray.t(obj);
		if(obj instanceof R) return rToMap.t(obj);
		if(obj instanceof T) return tToMap.t(obj);
		if(obj instanceof String) return fromString.t(obj);
		if(obj instanceof File) return fromFile.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
