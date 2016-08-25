package gus06.entity.gus.data.perform.append0;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;
import java.io.File;
import java.util.Iterator;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160312";}




	public EntityImpl() throws Exception
	{
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		appendObj(o[0],o[1]);
	}
	
	
	private void appendObj(Object data, Object value) throws Exception
	{
		if(data instanceof StringBuffer)
		{
			StringBuffer sb = (StringBuffer) data;
			append0(sb,value);
			return;
		}
		if(data instanceof StringBuilder)
		{
			StringBuilder sb = (StringBuilder) data;
			append0(sb,value);
			return;
		}
		if(data instanceof Collection)
		{
			Collection c = (Collection) data;
			Collection c0 = (Collection) value;
			append0(c,c0);
			return;
		}
		if(data instanceof Map) 
		{
			Map m = (Map) data;
			Map m0 = (Map) value;
			append0(m,m0);
			return;
		}
		if(data instanceof File) 
		{
			File f = (File) data;
			append0(f,value);
			return;
		}
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
	
	
	private void append0(StringBuffer sb, Object value)
	{
		if(sb.length()>0)
		sb.append(value.toString());
	}
	
	private void append0(StringBuilder sb, Object value)
	{
		if(sb.length()>0) 
		sb.append(value.toString());
	}
	
	private void append0(Collection c, Collection c0)
	{
		Iterator it = c0.iterator();
		while(it.hasNext())
		{
			Object element = it.next();
			if(!c.contains(element)) c.add(element);
		}
	}
	
	private void append0(Map m, Map m0)
	{
		Iterator it = m0.keySet().iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			if(!m.containsKey(key)) m.put(key,m0.get(key));
		}
	}
	
	private void append0(File f, Object value) throws Exception
	{
		if(f.isDirectory()) throw new Exception("Directory not supported yet: "+f);
		if(f.isFile()) throw new Exception("File not supported yet: "+f);
	}
}
