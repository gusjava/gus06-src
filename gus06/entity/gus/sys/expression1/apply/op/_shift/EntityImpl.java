package gus06.entity.gus.sys.expression1.apply.op._shift;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151119";}


	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof List) return shift((List) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Object shift(List l)
	{
		if(l.isEmpty()) return null;
		return l.remove(0);
	}
}
