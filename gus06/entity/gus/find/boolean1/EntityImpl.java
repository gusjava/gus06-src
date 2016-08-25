package gus06.entity.gus.find.boolean1;

import gus06.framework.*;
import javax.swing.border.Border;

public class EntityImpl implements Entity, T, F {

	public String creationDate() {return "20160414";}
	
	
	
	public boolean f(Object obj) throws Exception
	{
		if(obj instanceof Boolean) return ((Boolean) obj).booleanValue();
		
		if(obj instanceof Integer)
		{
			int v = ((Integer) obj).intValue();
			if(v==1) return true;
			if(v==0) return false;
			throw new Exception("Invalid integer value for boolean conversion: "+v);
		}
		
		if(obj instanceof String)
		{
			String s = ((String) obj).toLowerCase();
			if(s.equals("true")) return true;
			if(s.equals("false")) return false;
			throw new Exception("Invalid string value for boolean conversion");
		}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	
	public Object t(Object obj) throws Exception
	{return new Boolean(f(obj));}
}
