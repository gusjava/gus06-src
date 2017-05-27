package gus06.entity.gus.find.t;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151118";}


	private Service rToT;
	private Service fToT;
	private Service hToT;
	private Service mapToT;


	public EntityImpl() throws Exception
	{
		rToT = Outside.service(this,"gus.convert.rtot");
		fToT = Outside.service(this,"gus.convert.ftot");
		hToT = Outside.service(this,"gus.convert.htot");
		mapToT = Outside.service(this,"gus.convert.maptot");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		if(obj instanceof T) return obj;
		if(obj instanceof R) return rToT.t(obj);
		if(obj instanceof F) return fToT.t(obj);
		if(obj instanceof H) return hToT.t(obj);
		if(obj instanceof Map) return mapToT.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
