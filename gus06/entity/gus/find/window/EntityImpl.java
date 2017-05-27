package gus06.entity.gus.find.window;

import gus06.framework.*;
import java.awt.Window;
import java.awt.Component;
import javax.swing.SwingUtilities;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170412";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Window) return obj;
		if(obj instanceof Component) return SwingUtilities.getWindowAncestor((Component) obj);
		if(obj instanceof I) return SwingUtilities.getWindowAncestor((Component) ((I) obj).i());
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
