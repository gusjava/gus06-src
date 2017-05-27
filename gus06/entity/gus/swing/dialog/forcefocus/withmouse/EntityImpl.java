package gus06.entity.gus.swing.dialog.forcefocus.withmouse;

import gus06.framework.*;
import java.awt.Point;
import javax.swing.JDialog;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160916";}


	private Service mousePos;
	private Service mouseOrder;


	public EntityImpl() throws Exception
	{
		mousePos = Outside.service(this,"gus.mouse.position");
		mouseOrder = Outside.service(this,"gus.awt.robot.mouse.order");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JDialog dialog = (JDialog) obj;
		
		if(!dialog.isVisible()) return;
		
		int[] p0 = (int[]) mousePos.g();
		
		Point p = dialog.getLocationOnScreen();
		int[] p1 = new int[]{p.x+5,p.y+5};
		
		mouseOrder.v("position",p1);
		mouseOrder.v("click",null);
		mouseOrder.v("position",p0);
	}
}
