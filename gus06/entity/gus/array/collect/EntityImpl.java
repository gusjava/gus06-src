package gus06.entity.gus.array.collect;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151201";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object[] input = (Object[]) o[0];
		T t = (T) o[1];
		
		int nb = input.length;
		Object[] output = new Object[nb];
		
		for(int i=0;i<nb;i++)
		{
			Object element = input[i];
			output[i] = t.t(element);
		}
		return output;
	}
}
