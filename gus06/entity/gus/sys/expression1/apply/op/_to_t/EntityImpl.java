package gus06.entity.gus.sys.expression1.apply.op._to_t;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151113";}


	private Service builder;
	private Service mapToT;
	private Service rToT;
	private Service fToT;
	private Service hToT;
	private Service gToT;
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.sys.expression1.builder1.t");
		mapToT = Outside.service(this,"gus.convert.maptot");
		rToT = Outside.service(this,"gus.convert.rtot");
		fToT = Outside.service(this,"gus.convert.ftot");
		hToT = Outside.service(this,"gus.convert.htot");
		gToT = Outside.service(this,"gus.convert.gtot");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof T) return value;
		if(value instanceof Map) return mapToT.t(value);
		if(value instanceof R) return rToT.t(value);
		if(value instanceof F) return fToT.t(value);
		if(value instanceof H) return hToT.t(value);
		if(value instanceof G) return gToT.t(value);
		
		if(value instanceof String)
			return builder.t(new Object[]{value,opMap});
			
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
}
