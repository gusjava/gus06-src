package gus06.entity.gus.list.removeat;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20151205";}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List list = (List) o[0];
		int index = toInt(o[1]);
		
		int nb = list.size();
		if(index<0) index += nb;
		
		if(index<0 || index>=nb) return null;
		return list.remove(index);
	}
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
}
