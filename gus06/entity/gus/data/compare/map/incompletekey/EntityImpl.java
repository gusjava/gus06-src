package gus06.entity.gus.data.compare.map.incompletekey;

import gus06.framework.*;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151202";}



	public Object t(Object obj) throws Exception
	{
		Map[] mm = (Map[]) obj;
		if(mm.length<2) throw new Exception("Wrong data number: "+mm.length);
		
		Set output = new HashSet();
		for(Map m:mm) output.addAll(m.keySet());
		
		Iterator it = output.iterator();
		while(it.hasNext())
		{
			Object key = it.next();
			if(isEverywhere(mm,key)) it.remove();
		}
		return output;
	}
	
	
	private boolean isEverywhere(Map[] mm, Object key)
	{
		for(int i=0;i<mm.length;i++)
		{
			Map m = mm[i];
			if(!m.containsKey(key)) return false;
		}
		return true;
	}
}
