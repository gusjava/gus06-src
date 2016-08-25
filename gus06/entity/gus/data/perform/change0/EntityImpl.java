package gus06.entity.gus.data.perform.change0;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160311";}


	private Service writeFile;


	public EntityImpl() throws Exception
	{
		writeFile = Outside.service(this,"gus.file.write.generic");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		change0(o[0],o[1]);
	}
	
	
	private void change0(Object data, Object value) throws Exception
	{
		if(data instanceof StringBuffer)
		{
			StringBuffer sb = (StringBuffer) data;
			if(sb.length()==0) change(sb,value);
			return;
		}
		if(data instanceof StringBuilder)
		{
			StringBuilder sb = (StringBuilder) data;
			if(sb.length()==0) change(sb,value);
			return;
		}
		if(data instanceof Collection)
		{
			Collection c = (Collection) data;
			if(c.isEmpty()) change(c,value);
			return;
		}
		if(data instanceof Map) 
		{
			Map m = (Map) data;
			if(m.isEmpty()) change(m,value);
			return;
		}
		if(data instanceof File) 
		{
			File f = (File) data;
			if(!f.exists() || (f.isFile() && f.length()==0)) change(f,value);
			return;
		}
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
	
	
	private void change(StringBuffer b, Object value)
	{
		b.append(value.toString());
	}
	
	private void change(StringBuilder b, Object value)
	{
		b.append(value.toString());
	}
	
	private void change(Collection c, Object value)
	{
		c.addAll((Collection) value);
	}
	
	private void change(Map m, Object value)
	{
		m.putAll((Map) value);
	}
	
	private void change(File f, Object value) throws Exception
	{
		writeFile.p(new Object[]{f,value});
	}
}
