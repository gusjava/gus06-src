package gus06.entity.gus.sys.expression1.apply.op._h_cos;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160722";}

	public static final String T = "constant";


	private Service function;
	
	public EntityImpl() throws Exception
	{
		function = Outside.service(this,"gus.math.function.trigo.cosine");
	}


	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		return function;
	}
}
