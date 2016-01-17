package gus06.entity.gus.sys.parser3.evaluate;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, V, T {

	public String creationDate() {return "20151031";}


	private Service prepare;
	private Service resolver1;
	private Service resolver2;
	
	private T external;
	private String rule;
	
	public EntityImpl() throws Exception
	{
		prepare = Outside.service(this,"gus.sys.parser3.prepare");
		resolver1 = Outside.service(this,"gus.sys.parser3.resolver1");
		resolver2 = Outside.service(this,"gus.sys.parser3.resolver2");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(rule!=null)
		{
			resolver2.v("external",external);
			return resolver2.t(new Object[]{toList(obj),rule});
		}
		
		resolver1.v("external",external);
		return resolver1.t(toList(obj));
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("external")) {external = (T) obj;return;}
		if(key.equals("rule")) {rule = (String) obj;return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	private List toList(Object obj) throws Exception
	{return (List) prepare.t(obj);}
}
