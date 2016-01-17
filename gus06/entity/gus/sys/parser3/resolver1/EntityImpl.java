package gus06.entity.gus.sys.parser3.resolver1;

import gus06.framework.*;
import java.util.List;
import java.util.Map;

public class EntityImpl implements Entity, V, R, T {

	public String creationDate() {return "20151027";}
	
	
	private Service resolveTag;
	private Service resolveUnary;
	private Service opListProvider;
	
	private T external;
	
	
	public EntityImpl() throws Exception
	{
		resolveTag = Outside.service(this,"gus.sys.parser3.resolver1.tag");
		resolveUnary = Outside.service(this,"gus.sys.parser3.resolver1.op.unary");
		opListProvider = Outside.service(this,"gus.sys.parser3.resolver1.oplist");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("external")) {external = (T) obj;return;}
		throw new Exception("Unknown key: "+key);
	}
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("external")) return external;
		if(key.equals("keys")) return new String[]{"external"};
		throw new Exception("Unknown key: "+key);
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
		if(l.size()==2)		return resolveUnary(l);
		
		List ops = (List) opListProvider.g();
		
		for(int i=0;i<ops.size();i++)
		{
			T[] t = (T[]) ops.get(i);
			Object cut = t[0].t(l);
			if(cut!=null) return t[1].t(new Object[]{cut,this});
		}
		
		throw new Exception("Failed to resolve list");
	}
	
	
	
	
	private Object resolveTag(List l) throws Exception
	{return resolveTag.t(new Object[]{l.get(0),this});}
	
	private Object resolveTag(Map m) throws Exception
	{return resolveTag.t(new Object[]{m,this});}
	
	private Object resolveUnary(List l) throws Exception
	{return resolveUnary.t(new Object[]{l,this});}
}
