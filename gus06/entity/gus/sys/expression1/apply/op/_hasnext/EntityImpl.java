package gus06.entity.gus.sys.expression1.apply.op._hasnext;

import gus06.framework.*;
import java.sql.ResultSet;
import java.util.Iterator;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20151115";}


	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof ResultSet) return new Boolean(((ResultSet)obj).next());
		if(obj instanceof Iterator) return new Boolean(((Iterator)obj).hasNext());
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("types")) return new Class[]{ResultSet.class,Iterator.class};
		if(key.equals("keys")) return new String[]{"types"};
		throw new Exception("Unknown key: "+key);
	}
}
