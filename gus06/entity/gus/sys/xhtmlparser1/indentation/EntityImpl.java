package gus06.entity.gus.sys.xhtmlparser1.indentation;

import gus06.framework.*;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170218";}
	
	public static final String K_CONTENT = "content";


	private Service handle;
	
	public EntityImpl() throws Exception
	{
		handle = Outside.service(this,"gus.sys.xhtmlparser1.indentation.handle");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Map root = (Map) obj;
		if(root==null) return "";
		
		List content = (List) get(root,K_CONTENT);
		if(content==null) return "";
		
		StringBuffer b = new StringBuffer();
		
		for(int i=0;i<content.size();i++)
		{
			Map child = (Map) content.get(i);
			handleMap(b,child,"");
		}
		return b.toString().trim();
	}
	
	
	private void handleMap(StringBuffer b, Map map, String offset) throws Exception
	{handle.p(new Object[]{b,map,offset});}
	
	
	private Object get(Map map, String key)
	{return map.containsKey(key)? map.get(key):null;}
}
