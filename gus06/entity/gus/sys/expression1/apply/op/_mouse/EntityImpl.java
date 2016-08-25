package gus06.entity.gus.sys.expression1.apply.op._mouse;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160407";}


	private Service mousePosition;
	
	public EntityImpl() throws Exception
	{mousePosition = Outside.service(this,"gus.mouse.position.str");}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return mousePosition.g();
	}
}
