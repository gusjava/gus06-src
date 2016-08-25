package gus06.entity.gus.sys.expression1.apply.op._e_beep;

import gus06.framework.*;
import java.awt.Toolkit;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160419";}

	public static final String T = "constant";

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return new E1();
	}
	
	private class E1 implements E
	{
		public void e() throws Exception
		{Toolkit.getDefaultToolkit().beep();}
	}
}
