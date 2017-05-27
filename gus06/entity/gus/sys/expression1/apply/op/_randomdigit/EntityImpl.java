package gus06.entity.gus.sys.expression1.apply.op._randomdigit;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161215";}

	public static final String T = "constant";


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return ""+random(10);
	}
	
	
	private int random(int n)
	{return (int) (Math.random()*n);}
}
