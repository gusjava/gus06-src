package gus06.entity.gus.data.perform.searchall;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151201";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		F filter = (F) o[1];
		
		Map output = new HashMap();
		handleObj(filter,"",output,input);
		return output;
	}
	
	private void handleObj(F filter, String path, Map output, Object input) throws Exception
	{
		if(input instanceof List) handleList(filter,path,output,(List) input);
		else if(input instanceof Set) handleSet(filter,path,output,(Set) input);
		else if(input instanceof Map) handleMap(filter,path,output,(Map) input);
		else if(input instanceof Object[]) handleArray(filter,path,output,(Object[]) input);
		
		else if(input instanceof String) handleString(filter,path,output,(String) input);
		else if(input instanceof Number) handleNumber(filter,path,output,(Number) input);
		else if(input instanceof Boolean) handleBoolean(filter,path,output,(Boolean) input);
		else if(input instanceof File) handleFile(filter,path,output,(File) input);
		
		else  throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	private void handleList(F filter, String path, Map output, List input) throws Exception
	{
		for(int i=0;i<input.size();i++)
		{
			String newPath = path+"."+i;
			Object element = input.get(i);
			handleObj(filter,newPath,output,element);
		}
	}
	
	private void handleSet(F filter, String path, Map output, Set input) throws Exception
	{
		Iterator it = input.iterator();
		while(it.hasNext())
		{
			String newPath = path+".*";
			Object element = it.next();
			handleObj(filter,newPath,output,element);
		}
	}
	
	private void handleMap(F filter, String path, Map output, Map input) throws Exception
	{
		Iterator it = input.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			Object value = input.get(key);
			String newPath = path+"."+key;
			handleObj(filter,newPath,output,value);
		}
	}
	
	private void handleArray(F filter, String path, Map output, Object[] input) throws Exception
	{
		for(int i=0;i<input.length;i++)
		{
			String newPath = path+"."+i;
			Object element = input[i];
			handleObj(filter,newPath,output,element);
		}
	}
	
	private void handleString(F filter, String path, Map output, String input) throws Exception
	{
		if(filter.f(input))
		{
			if(path.startsWith(".")) path = path.substring(1);
			output.put(path,input);
		}
	}
	
	private void handleNumber(F filter, String path, Map output, Number input) throws Exception
	{
		if(filter.f(input))
		{
			if(path.startsWith(".")) path = path.substring(1);
			output.put(path,input);
		}
	}
	
	private void handleBoolean(F filter, String path, Map output, Boolean input) throws Exception
	{
		if(filter.f(input))
		{
			if(path.startsWith(".")) path = path.substring(1);
			output.put(path,input);
		}
	}
	
	private void handleFile(F filter, String path, Map output, File input) throws Exception
	{
		if(filter.f(input))
		{
			if(path.startsWith(".")) path = path.substring(1);
			output.put(path,input);
		}
		
		if(input.isDirectory()) 
		{
			String newPath = path+"."+input.getName();
			handleDir(filter,newPath,output,input);
		}
	}
	
	private void handleDir(F filter, String path, Map output, File input) throws Exception
	{
		File[] ff = input.listFiles();
		for(int i=0;i<ff.length;i++)
		{
			String newPath = path+"."+i;
			File f = ff[i];
			handleFile(filter,newPath,output,f);
		}
	}
}
