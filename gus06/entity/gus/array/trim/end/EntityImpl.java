package gus06.entity.gus.array.trim.end;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170301";}
	
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] input = (Object[]) obj;
		
		int end = findEnd(input);
		if(end==-1) return new ArrayList();
		
		List output = new ArrayList();
		for(int i=0;i<=end;i++) output.add(input[i]);
		
		return output;
	}
	
	private int findEnd(Object[] array) throws Exception
	{
		int nb = array.length;
		for(int i=0;i<nb;i++)
		if(!isEmpty(array[nb-1-i])) return nb-1-i;
		return -1;
	}
	
	private boolean isEmpty(Object obj) throws Exception
	{
		if(obj==null) return true;
		if(obj instanceof String) return ((String)obj).trim().equals("");
		if(obj instanceof Object[]) return ((Object[])obj).length==0;
		if(obj instanceof Collection) return ((Collection)obj).isEmpty();
		if(obj instanceof Map) return ((Map)obj).isEmpty();
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
