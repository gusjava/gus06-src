package gus06.entity.gus.sys.expression1.apply.op._showdebug;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170408";}


	private Service show;
	
	
	public EntityImpl() throws Exception
	{
		show = Outside.service(this,"gus.debug.gui.maingui.show");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		return show;
	}
}
