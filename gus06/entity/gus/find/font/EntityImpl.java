package gus06.entity.gus.find.font;

import gus06.framework.*;
import java.awt.Font;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140729";}


	private Service stringToFont;
	private Service mapToFont;

	public EntityImpl() throws Exception
	{
		stringToFont = Outside.service(this,"gus.convert.stringtofont");
		mapToFont = Outside.service(this,"gus.convert.maptofont");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		if(obj instanceof Font) return obj;
		if(obj instanceof String) return stringToFont.t(obj);
		if(obj instanceof Map) return mapToFont.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
