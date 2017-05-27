package gus06.entity.gus.sys.xhtmlparser1.indentation.handle;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170226";}
	
	public static final String K_TYPE = "type";
	
	public static final String T_TEXT = "text";
	public static final String T_ELEMENT = "element";
	public static final String T_COMMENT = "comment";
	
	
	
	private Service handleText;
	private Service handleComment;
	private Service handleElement;
	
	public EntityImpl() throws Exception
	{
		handleText = Outside.service(this,"gus.sys.xhtmlparser1.indentation.handle.text");
		handleComment = Outside.service(this,"gus.sys.xhtmlparser1.indentation.handle.comment");
		handleElement = Outside.service(this,"gus.sys.xhtmlparser1.indentation.handle.element");
	}



	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		StringBuffer b = (StringBuffer) o[0];
		Map map = (Map) o[1];
		String offset = (String) o[2];
		
		
		if(isText(map))
		{
			handleText.p(obj);
		}
		else if(isComment(map))
		{
			handleComment.p(obj);
		}
		else if(isElement(map))
		{
			handleElement.p(new Object[]{b,map,offset,this});
		}
	}
	
	
	
	private boolean isText(Map map) throws Exception
	{return type(map).equals(T_TEXT);}
	
	private boolean isComment(Map map) throws Exception
	{return type(map).equals(T_COMMENT);}
	
	private boolean isElement(Map map) throws Exception
	{return type(map).equals(T_ELEMENT);}
	
	
	
	private String type(Map map) throws Exception
	{return (String) get1(map,K_TYPE);}
	
	private Object get1(Map map, String key) throws Exception
	{
		if(!map.containsKey(key)) throw new Exception("Key not found: "+key);
		return  map.get(key);
	}
}
