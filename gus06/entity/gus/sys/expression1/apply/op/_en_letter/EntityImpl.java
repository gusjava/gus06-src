package gus06.entity.gus.sys.expression1.apply.op._en_letter;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160502";}


	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new Boolean(matches((String) obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public boolean matches(String s) throws Exception
	{
		return s.matches(".*[a-zA-Z]$");
	}
}
