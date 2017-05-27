package gus06.entity.gus.data.perform.hide;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import java.awt.Window;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160922";}

	
	
	public void p(Object obj) throws Exception
	{
		Window window = toWindow(obj);
		window.setVisible(false);
	}
	
	
	private Window toWindow(Object obj) throws Exception
	{
		if(obj instanceof Window) return (Window) obj;
		
		if(obj instanceof I)
			return SwingUtilities.getWindowAncestor((JComponent) ((I) obj).i());
		if(obj instanceof JComponent)
			return SwingUtilities.getWindowAncestor((JComponent) obj);
			
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
