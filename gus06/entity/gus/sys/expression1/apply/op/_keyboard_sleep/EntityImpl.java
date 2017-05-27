package gus06.entity.gus.sys.expression1.apply.op._keyboard_sleep;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170409";}

	public static final String T = "constant";


	private Service activity;
	
	public EntityImpl() throws Exception
	{activity = Outside.service(this,"gus.jna.keyboard.activity");}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return new Boolean(!activity.f(null));
	}
}
