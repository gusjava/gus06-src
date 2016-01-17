package gus06.entity.gus.sys.parser3.resolver1.op.binary.inf2;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151029";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List[] cut = (List[]) o[0];
		T t = (T) o[1];
		
		if(cut.length!=2) throw new Exception("Invalid split for equals operation: "+cut.length);
		
		List l1 = cut[0];
		List l2 = cut[1];
		
		double d1 = toNum(tt(t,l1)).doubleValue();
		double d2 = toNum(tt(t,l2)).doubleValue();
		return new Boolean(d1 < d2);
	}
	
	private Number toNum(Object obj) throws Exception
	{
		if(!(obj instanceof Number)) throw new Exception("Invalid data type: "+obj.getClass().getName());
		return (Number) obj;
	}
	
	private Object tt(T t, List l) throws Exception
	{
		Object r = t.t(l);
		if(r==null) throw new Exception("No value found for "+l);
		return r;
	}
}
