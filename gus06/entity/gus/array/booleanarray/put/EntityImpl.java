package gus06.entity.gus.array.booleanarray.put;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20170429";}


	private Service ruleToIndex;
	
	public EntityImpl() throws Exception
	{
		ruleToIndex = Outside.service(this,"gus.list.ruletoindex");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		boolean[] array = (boolean[]) o[0];
		Object key = o[1];
		Boolean value = (Boolean) o[2];
		
		Integer n = (Integer) ruleToIndex.t(new Object[]{array,key});
		if(n==null) throw new Exception("Invalid rule for index: "+key);
		
		int index = n.intValue();
		array[index] = value.booleanValue();
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		boolean[] array = (boolean[]) o[0];
		Object key = o[1];
		Boolean value = (Boolean) o[2];
		
		boolean[] array1 = new boolean[array.length];
		for(int i=0;i<array.length;i++) array1[i] = array[i];
		
		Integer n = (Integer) ruleToIndex.t(new Object[]{array,key});
		if(n==null) throw new Exception("Invalid rule for index: "+key);
		
		int index = n.intValue();
		array1[index] = value.booleanValue();
		
		return array1;
	}
}
