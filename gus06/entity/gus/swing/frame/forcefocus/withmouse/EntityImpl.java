package gus06.entity.gus.swing.frame.forcefocus.withmouse;

import gus06.framework.*;
import javax.swing.JFrame;
import java.awt.Point;

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
		JFrame frame = (JFrame) obj;
		
		if(!frame.isVisible()) return;
		
		int[] p0 = (int[]) mousePos.g();
		
		Point p = frame.getLocationOnScreen();
		int[] p1 = new int[]{p.x+5,p.y+5};
		
		mouseOrder.v("position",p1);
		mouseOrder.v("click",null);
		mouseOrder.v("position",p0);
	}
}
