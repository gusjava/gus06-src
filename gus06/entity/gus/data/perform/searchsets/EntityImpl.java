package gus06.entity.gus.data.perform.searchsets;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161031";}
	
	
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
		if(input instanceof List)
			handleList(filter,path,output,(List) input);
		else if(input instanceof Set)
			handleSet(filter,path,output,(Set) input);
		else if(input instanceof Map)
			handleMap(filter,path,output,(Map) input);
		else if(input instanceof Object[])
			handleArray(filter,path,output,(Object[]) input);
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
		
		if(filter.f(input))
		{
			if(path.startsWith(".")) path = path.substring(1);
			output.put(path,input);
		}
	}
}
