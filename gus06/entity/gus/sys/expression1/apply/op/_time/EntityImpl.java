package gus06.entity.gus.sys.expression1.apply.op._time;

import gus06.framework.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160725";}
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return today();
	}
	
	private String today() throws Exception
	{return sdf.format(new Date());}
}
