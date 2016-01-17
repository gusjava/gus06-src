package gus06.entity.gus.find.font;

import gus06.framework.*;
import java.awt.Font;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140729";}


	private Service stringToFont;

	public EntityImpl() throws Exception
	{stringToFont = Outside.service(this,"gus.convert.stringtofont");}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Font) return obj;
		if(obj instanceof String) return stringToFont((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Font stringToFont(String s) throws Exception
	{return (Font) stringToFont.t(s);}
}
