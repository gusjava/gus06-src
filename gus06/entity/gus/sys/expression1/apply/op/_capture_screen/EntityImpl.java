package gus06.entity.gus.sys.expression1.apply.op._capture_screen;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160505";}

	public static final String T = "constant";


	private Service printScreen;
	
	
	public EntityImpl() throws Exception
	{
		printScreen = Outside.service(this,"gus.awt.robot.printscreen");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return printScreen.g();
	}
	
}
