package gus06.entity.gus.tostring.displayall;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160809";}
	
	public static final int LIMIT_STRING = 50;


	private Service encodeString;
	private Service buildDesc;


	public EntityImpl() throws Exception
	{
		encodeString = Outside.service(this,"gus.string.transform.encoding.datastring.encode");
		buildDesc = Outside.service(this,"gus.tostring.desc.short1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		StringBuffer b = new StringBuffer();
		handleObj("",b,obj);
		return b.toString()+"\n";
	}
	
	
	private void handleObj(String offset, StringBuffer b, Object obj) throws Exception
	{
		if(obj==null) b.append("null");
		
		else if(obj instanceof Number) b.append(obj);
		else if(obj instanceof Boolean) b.append(obj);
		
		else if(obj instanceof String)		handleString(b,(String) obj);
		else if(obj instanceof Map)		handleMap(offset,b,(Map) obj);
		else if(obj instanceof Set)		handleSet(offset,b,(Set) obj);
		else if(obj instanceof List)		handleList(offset,b,(List) obj);
		else if(obj instanceof Object[])	handleArray(offset,b,(Object[]) obj);
		else if(obj instanceof int[])		handleArrayInt(offset,b,(int[]) obj);
		else if(obj instanceof long[])		handleArrayLong(offset,b,(long[]) obj);
		else if(obj instanceof double[])	handleArrayDouble(offset,b,(double[]) obj);
		else if(obj instanceof float[])		handleArrayFloat(offset,b,(float[]) obj);
		else if(obj instanceof boolean[])	handleArrayBoolean(offset,b,(boolean[]) obj);
		else if(obj instanceof char[])		handleArrayChar(offset,b,(char[]) obj);
		
		else handleOther(b,obj);
	}
	
	
	private void handleString(StringBuffer b, String s) throws Exception
	{
		String s_ = (String) encodeString.t(s);
		if(s_.length()>LIMIT_STRING) s_ = s_.substring(0,LIMIT_STRING)+"...";
		b.append("\""+s_+"\"");
	}
	
	
	private void handleMap(String offset, StringBuffer b, Map m) throws Exception
	{
		b.append("{\n");
		List l = new ArrayList(m.keySet());
		for(int i=0;i<l.size();i++)
		{
			String key = (String) l.get(i);
			Object value = m.get(key);
			
			b.append(offset+"\t");
			handleObj(offset,b,key);
			
			b.append(":");
			
			handleObj(offset+"\t",b,value);
			if(i<l.size()-1) b.append(",");
			
			b.append("\n");
		}
		b.append(offset+"}");
	}
	
	
	private void handleSet(String offset, StringBuffer b, Set s) throws Exception
	{
		b.append("{\n");
		List l = new ArrayList(s);
		for(int i=0;i<l.size();i++)
		{
			Object value = l.get(i);
			b.append(offset+"\t");
			handleObj(offset+"\t",b,value);
			if(i<l.size()-1) b.append(",");
			b.append("\n");
		}
		b.append(offset+"}");
	}
	
	
	private void handleList(String offset, StringBuffer b, List l) throws Exception
	{
		b.append("[\n");
		for(int i=0;i<l.size();i++)
		{
			Object value = l.get(i);
			b.append(offset+"\t");
			handleObj(offset+"\t",b,value);
			if(i<l.size()-1) b.append(",");
			b.append("\n");
		}
		b.append(offset+"]");
	}
	
	
	private void handleArray(String offset, StringBuffer b, Object[] a) throws Exception
	{
		b.append("[\n");
		for(int i=0;i<a.length;i++)
		{
			Object value = a[i];
			b.append(offset+"\t");
			handleObj(offset+"\t",b,value);
			if(i<a.length-1) b.append(",");
			b.append("\n");
		}
		b.append(offset+"]");
	}
	
	
	private void handleArrayInt(String offset, StringBuffer b, int[] a) throws Exception
	{
		b.append("[\n");
		for(int i=0;i<a.length;i++)
		{
			b.append(offset+"\t"+a[i]+"\n");
		}
		b.append(offset+"]");
	}
	
	
	private void handleArrayLong(String offset, StringBuffer b, long[] a) throws Exception
	{
		b.append("[\n");
		for(int i=0;i<a.length;i++)
		{
			b.append(offset+"\t"+a[i]+"\n");
		}
		b.append(offset+"]");
	}
	
	
	private void handleArrayDouble(String offset, StringBuffer b, double[] a) throws Exception
	{
		b.append("[\n");
		for(int i=0;i<a.length;i++)
		{
			b.append(offset+"\t"+a[i]+"\n");
		}
		b.append(offset+"]");
	}
	
	
	private void handleArrayFloat(String offset, StringBuffer b, float[] a) throws Exception
	{
		b.append("[\n");
		for(int i=0;i<a.length;i++)
		{
			b.append(offset+"\t"+a[i]+"\n");
		}
		b.append(offset+"]");
	}
	
	
	private void handleArrayBoolean(String offset, StringBuffer b, boolean[] a) throws Exception
	{
		b.append("[\n");
		for(int i=0;i<a.length;i++)
		{
			b.append(offset+"\t"+a[i]+"\n");
		}
		b.append(offset+"]");
	}
	
	
	private void handleArrayChar(String offset, StringBuffer b, char[] a) throws Exception
	{
		b.append("[\n");
		for(int i=0;i<a.length;i++)
		{
			b.append(offset+"\t"+a[i]+"\n");
		}
		b.append(offset+"]");
	}
	
	
	private void handleOther(StringBuffer b, Object obj) throws Exception
	{
		String desc = (String) buildDesc.t(obj);
		b.append(desc);
	}
}