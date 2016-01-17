package gus06.entity.gus.sys.script1.executor.find;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {
	
	public static final String T_ROOT = "root";
	public static final String T_ELEMENT = "element";
	public static final String T_TEXT = "text";


	public String creationDate() {return "20150829";}


	private Service typeRoot;
	private Service typeEl;
	private Service typeText;
	private Service getType;
	
	public EntityImpl() throws Exception
	{
		typeRoot = Outside.service(this,"gus.sys.script1.executor.type.root");
		typeEl = Outside.service(this,"gus.sys.script1.executor.type.el");
		typeText = Outside.service(this,"gus.sys.script1.executor.type.text");
		getType = Outside.service(this,"gus.sys.script1.access.tag.type1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map tag = (Map) obj;
		String type = (String) getType.t(tag);
		
		if(type.equals(T_ROOT)) return typeRoot.t(tag);
		if(type.equals(T_ELEMENT)) return typeEl.t(tag);
		if(type.equals(T_TEXT)) return typeText.t(tag);
		
		throw new Exception("Invalid type: "+type);
	}
}
