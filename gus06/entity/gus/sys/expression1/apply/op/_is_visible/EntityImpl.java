package gus06.entity.gus.sys.expression1.apply.op._is_visible;

import gus06.framework.*;
import java.awt.Window;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160916";}


	private Service findWindow;
	
	public EntityImpl() throws Exception
	{
		findWindow = Outside.service(this,"gus.find.window");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return Boolean.FALSE;
		
		Window window = (Window) findWindow.t(obj);
		return new Boolean(window.isVisible());
	}
}
