package gus06.entity.gus.sys.expression1.apply.op._tray_icons;

import gus06.framework.*;
import java.awt.SystemTray;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161003";}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(!SystemTray.isSupported())
			throw new Exception("SystemTray is not available");
		
		return SystemTray.getSystemTray().getTrayIcons();
	}
}
