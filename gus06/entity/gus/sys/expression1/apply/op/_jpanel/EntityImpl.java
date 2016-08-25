package gus06.entity.gus.sys.expression1.apply.op._jpanel;

import gus06.framework.*;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160505";}


	private Service colorToPanel;
	
	public EntityImpl() throws Exception
	{
		colorToPanel = Outside.service(this,"gus.convert.colortojpanel");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof Color) return colorToPanel.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
