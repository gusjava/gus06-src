package gus06.entity.gus.sys.expression1.apply.op._display;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151129";}


	private Service display;


	public EntityImpl() throws Exception
	{
		display = Outside.service(this,"gus.tostring.display");
	}
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return display.t(obj);
	}
}
