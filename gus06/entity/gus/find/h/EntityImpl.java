package gus06.entity.gus.find.h;

import gus06.framework.*;
import java.io.FileFilter;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160802";}


	private Service numberToH;

	public EntityImpl() throws Exception
	{
		numberToH = Outside.service(this,"gus.convert.numbertoh");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof H) return obj;
		if(obj instanceof Number) return numberToH.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
