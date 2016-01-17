package gus06.entity.gus.sys.jsonparser1.resolver;

import gus06.framework.*;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151125";}

	
	private Service resolveTag;
	
	public EntityImpl() throws Exception
	{
		resolveTag = Outside.service(this,"gus.sys.jsonparser1.resolver.tag");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof List)
			return resolveList((List) obj);
		if(obj instanceof Map)
			return resolveTag((Map) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Object resolveList(List l) throws Exception
	{
		if(l.size()==0)		return null;
		if(l.size()==1)		return resolveTag(l);
		
		throw new Exception("Failed to resolve list");
	}
	
	
	
	private Object resolveTag(List l) throws Exception
	{return resolveTag((Map) l.get(0));}
	
	private Object resolveTag(Map tag) throws Exception
	{return resolveTag.t(new Object[]{tag,this});}
}
