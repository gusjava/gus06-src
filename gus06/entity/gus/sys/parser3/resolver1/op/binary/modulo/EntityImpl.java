package gus06.entity.gus.sys.parser3.resolver1.op.binary.modulo;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List[] cut = (List[]) o[0];
		T t = (T) o[1];
		
		if(cut.length!=2) throw new Exception("Invalid split for equals operation: "+cut.length);
		
		List l1 = cut[0];
		List l2 = cut[1];
		
		int n1 = toInt(t.t(l1)).intValue();
		int n2 = toInt(t.t(l2)).intValue();
		return new Integer(n1%n2);
	}
	
	private Integer toInt(Object obj) throws Exception
	{
		if(!(obj instanceof Integer)) throw new Exception("Invalid data type: "+obj.getClass().getName());
		return (Integer) obj;
	}
}
