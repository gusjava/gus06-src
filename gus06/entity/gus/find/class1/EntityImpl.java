package gus06.entity.gus.find.class1;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140819";}


	private Service stringToClass;

	public EntityImpl() throws Exception
	{
		stringToClass = Outside.service(this,"gus.convert.stringtoclass");
	}


	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Class) return obj;
		if(obj instanceof String) return stringToClass.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
		
}
