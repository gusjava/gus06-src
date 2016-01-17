package gus06.entity.gus.list.each;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151125";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List input = (List) o[0];
		T t = (T) o[1];
		
		List output = new ArrayList();
		int nb = input.size();
		
		for(int i=0;i<nb;i++)
		{
			Object element = input.get(i);
			output.add(t.t(element));
		}
		input.clear();
		input.addAll(output);
	}
}
