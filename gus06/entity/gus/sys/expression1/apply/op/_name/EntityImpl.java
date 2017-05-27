package gus06.entity.gus.sys.expression1.apply.op._name;

import gus06.framework.*;
import java.io.File;
import java.nio.charset.Charset;
import java.net.URL;
import java.util.TimeZone;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}


	private Service performUrl;
	
	public EntityImpl() throws Exception
	{
		performUrl = Outside.service(this,"gus.url.getname");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof URL) return performUrl.t(obj);
		if(obj instanceof File) return ((File) obj).getName();
		if(obj instanceof Class) return getName((Class) obj);
		if(obj instanceof Entity) return getName((Entity) obj);
		if(obj instanceof Charset) return ((Charset) obj).name();
		if(obj instanceof TimeZone) return ((TimeZone) obj).getID();
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private String getName(Class c)
	{
		return c.getSimpleName();
	}
	
	private String getName(Entity entity) 
	{
		String s = entity.getClass().getName();
		return s.substring(13,s.length()-11);
	}
}
