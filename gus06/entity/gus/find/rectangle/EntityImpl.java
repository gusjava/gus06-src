package gus06.entity.gus.find.rectangle;

import gus06.framework.*;
import java.awt.Rectangle;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170306";}


	private Service fromIntArray;
	private Service fromString;

	public EntityImpl() throws Exception
	{
		fromIntArray = Outside.service(this,"gus.convert.intarraytorectangle");
		fromString = Outside.service(this,"gus.convert.stringtorectangle");
	}

	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Rectangle) return obj;
		if(obj instanceof int[]) return fromIntArray.t(obj);
		if(obj instanceof String) return fromString.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
