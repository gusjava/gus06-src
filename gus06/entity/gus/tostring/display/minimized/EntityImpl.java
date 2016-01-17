package gus06.entity.gus.tostring.display.minimized;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151129";}
	
	public static final int LIMIT = 10;


	private Service encodeString;


	public EntityImpl() throws Exception
	{
		encodeString = Outside.service(this,"gus.string.transform.encoding.datastring.encode");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		StringBuffer b = new StringBuffer();
		handleObj(0,b,obj);
		return b.toString();
	}
	
	
	private void handleObj(int c, StringBuffer b, Object obj) throws Exception
	{
		if(c > LIMIT) {b.append("...");return;}
		
		if(obj==null) b.append("null");
		
		else if(obj instanceof Number) b.append(obj);
		else if(obj instanceof Boolean) b.append(obj);
		
		else if(obj instanceof String)		handleString(b,(String) obj);
		else if(obj instanceof Map)		handleMap(c+1,b,(Map) obj);
		else if(obj instanceof Set)		handleSet(c+1,b,(Set) obj);
		else if(obj instanceof List)		handleList(c+1,b,(List) obj);
		else if(obj instanceof Object[])	handleArray(c+1,b,(Object[]) obj);
		
		else b.append(obj.getClass().getSimpleName());
	}
	
	
	private void handleString(StringBuffer b, String s) throws Exception
	{
		String s_ = (String) encodeString.t(s);
		b.append("\""+s_+"\"");
	}
	
	
	private void handleMap(int c, StringBuffer b, Map m) throws Exception
	{
		b.append("{");
		List l = new ArrayList(m.keySet());
		for(int i=0;i<l.size();i++)
		{
			String key = (String) l.get(i);
			Object value = m.get(key);
			
			handleString(b,key);
			b.append(":");
			handleObj(c,b,value);
			if(i<l.size()-1) b.append(",");
		}
		b.append("}");
	}
	
	
	private void handleSet(int c, StringBuffer b, Set s) throws Exception
	{
		b.append("{");
		List l = new ArrayList(s);
		for(int i=0;i<l.size();i++)
		{
			Object value = l.get(i);
			
			handleObj(c,b,value);
			if(i<l.size()-1) b.append(",");
		}
		b.append("}");
	}
	
	
	private void handleList(int c, StringBuffer b, List l) throws Exception
	{
		b.append("[");
		for(int i=0;i<l.size();i++)
		{
			Object value = l.get(i);
			
			handleObj(c,b,value);
			if(i<l.size()-1) b.append(",");
		}
		b.append("]");
	}
	
	
	private void handleArray(int c, StringBuffer b, Object[] a) throws Exception
	{
		b.append("[");
		for(int i=0;i<a.length;i++)
		{
			Object value = a[i];
			
			handleObj(c,b,value);
			if(i<a.length-1) b.append(",");
		}
		b.append("]");
	}
}
