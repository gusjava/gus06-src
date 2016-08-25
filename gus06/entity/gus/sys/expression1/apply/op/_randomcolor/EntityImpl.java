package gus06.entity.gus.sys.expression1.apply.op._randomcolor;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160505";}

	public static final String T = "constant";


	private Service randomColor;
	
	public EntityImpl() throws Exception
	{
		randomColor = Outside.service(this,"gus.awt.color.random");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return randomColor.g();
	}
}
