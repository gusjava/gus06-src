package gus06.entity.gus.feature.op.pipe.list;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151122";}

	
	public Object t(Object obj) throws Exception
	{
		List[] ll = (List[]) obj;
		List output = new ArrayList();
		if(ll.length==0) return output;
		
		for(int i=0;i<ll[0].size();i++)
		{
			Object value = findValue(ll,new Integer(i));
			if(value!=null) output.add(value);
		}
		return output;
	}
	
	
	private Object findValue(List[] ll, Object o)
	{
		for(List l:ll) o = get(l,o);
		return o;
	}
	
	private Object get(List l, Object o)
	{
		if(o==null) return null;
		if(!(o instanceof Integer)) return o;
		
		int index = ((Integer) o).intValue();
		if(index<0 || index>=l.size()) return null;
		return l.get(index);
	}
}
