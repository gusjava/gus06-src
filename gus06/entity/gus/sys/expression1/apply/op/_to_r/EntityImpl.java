package gus06.entity.gus.sys.expression1.apply.op._to_r;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151124";}


	private Service builder;
	private Service mapToR;
	private Service tToR;
	private Service fToR;
	private Service hToR;
	private Service gToR;
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.sys.expression1.builder1.r");
		mapToR = Outside.service(this,"gus.convert.maptor");
		tToR = Outside.service(this,"gus.convert.ttor");
		fToR = Outside.service(this,"gus.convert.ftor");
		hToR = Outside.service(this,"gus.convert.htor");
		gToR = Outside.service(this,"gus.convert.gtor");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof R) return value;
		if(value instanceof Map) return mapToR.t(value);
		if(value instanceof T) return tToR.t(value);
		if(value instanceof F) return fToR.t(value);
		if(value instanceof H) return hToR.t(value);
		if(value instanceof G) return gToR.t(value);
		
		if(value instanceof String)
			return builder.t(new Object[]{value,opMap});
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
}
