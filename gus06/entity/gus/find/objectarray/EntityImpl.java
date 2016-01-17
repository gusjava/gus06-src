package gus06.entity.gus.find.objectarray;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151101";}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Object[]) return (Object[]) obj;
		if(obj instanceof List) return toArray((List) obj);
		return toArray(obj);
	}
	
	private Object[] toArray(List l)
	{
		Object[] oo = new Object[l.size()];
		for(int i=0;i<l.size();i++) oo[i] = l.get(i);
		return oo;
	}
	
	private Object[] toArray(Object o)
	{
		return new Object[]{o};
	}
}
