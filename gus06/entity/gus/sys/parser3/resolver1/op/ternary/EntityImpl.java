package gus06.entity.gus.sys.parser3.resolver1.op.ternary;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151029";}


	public static final String TYPE = "type";
	public static final String VALUE = "value";
	
	public static final String TYPE_SYMBOL = "symbol";
	
	

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List[] cut = (List[]) o[0];
		T t = (T) o[1];
		
		if(cut.length!=3) throw new Exception("Invalid split for ternary operation: "+cut.length);
		
		List l1 = cut[0];
		List l2 = cut[1];
		List l3 = cut[2];
		
		Boolean r = toBool(t.t(l1));
		List l = r.booleanValue() ? l2 : l3;
		return t.t(l);
	}
	
	
	private Boolean toBool(Object obj) throws Exception
	{
		if(!(obj instanceof Boolean)) throw new Exception("Invalid data type: "+obj.getClass().getName());
		return (Boolean) obj;
	}
}
