package gus06.entity.gus.swing.frame.frametobounds;

import gus06.framework.*;
import java.awt.Rectangle;
import javax.swing.JFrame;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140912";}

	
	public Object t(Object obj) throws Exception
	{
		JFrame frame = (JFrame) obj;
		Rectangle rect = frame.getBounds();
		
		int x = rect.x;
		int y = rect.y;
		int w = rect.width;
		int h = rect.height;
		
		return x+" "+y+" "+w+" "+h;
	}
}
