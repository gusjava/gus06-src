package gus06.entity.gus.find.number;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151205";}


	private Service stringToNumber;


	public EntityImpl() throws Exception
	{
		stringToNumber = Outside.service(this,"gus.convert.stringtonumber");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Number) return obj;
		if(obj instanceof String) return stringToNumber.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
