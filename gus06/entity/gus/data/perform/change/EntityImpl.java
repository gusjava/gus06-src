package gus06.entity.gus.data.perform.change;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151204";}


	private Service writeFile;


	public EntityImpl() throws Exception
	{
		writeFile = Outside.service(this,"gus.file.write.generic");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		change(o[0],o[1]);
	}
	
	
	private void change(Object data, Object value) throws Exception
	{
		if(data instanceof StringBuffer)
		{change((StringBuffer) data,value);return;}
		
		if(data instanceof Collection)
		{change((Collection) data,value);return;}
		
		if(data instanceof Map) 
		{change((Map) data,value);return;}
		
		if(data instanceof File)
		{change((File) data,value);return;}
		
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
	
	
	private void change(StringBuffer b, Object value)
	{
		b.setLength(0);
		b.append(value.toString());
	}
	
	private void change(Collection c, Object value)
	{
		c.clear();
		c.addAll((Collection) value);
	}
	
	private void change(Map m, Object value)
	{
		m.clear();
		m.putAll((Map) value);
	}
	
	private void change(File f, Object value) throws Exception
	{
		if(f.isFile()) writeFile.p(new Object[]{f,value});
		else if(f.isDirectory()) throw new Exception("Directory not supported yet: "+f);
	}
}
