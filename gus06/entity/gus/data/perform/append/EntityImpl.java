package gus06.entity.gus.data.perform.append;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151204";}




	public EntityImpl() throws Exception
	{
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		append(o[0],o[1]);
	}
	
	
	private void append(Object data, Object value) throws Exception
	{
		if(data instanceof StringBuffer)
		{append((StringBuffer) data,value);return;}
		
		if(data instanceof Collection)
		{append((Collection) data,value);return;}
		
		if(data instanceof Map) 
		{append((Map) data,value);return;}
		
		if(data instanceof File)
		{append((File) data,value);return;}
		
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
	
	
	private void append(StringBuffer b, Object value)
	{
		b.append(value.toString());
	}
	
	private void append(Collection c, Object value)
	{
		c.addAll((Collection) value);
	}
	
	private void append(Map m, Object value)
	{
		m.putAll((Map) value);
	}
	
	private void append(File f, Object value) throws Exception
	{
		if(f.isFile()) throw new Exception("File not supported yet: "+f);
		else if(f.isDirectory()) throw new Exception("Directory not supported yet: "+f);
	}
}
