package gus06.entity.gus.sys.expression1.apply.op._creationdate;

import gus06.framework.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20151110";}
	
	private SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Entity) return creationDate((Entity) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("types")) return new Class[]{Entity.class};
		if(key.equals("keys")) return new String[]{"types"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	private Date creationDate(Entity entity) throws Exception
	{
		String timeStamp = entity.creationDate();
		return yyyyMMdd.parse(timeStamp);
	}
}
