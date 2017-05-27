package gus06.entity.gus.awt.robot.printscreen;

import gus06.framework.*;
import java.awt.*;

public class EntityImpl implements Entity, G, T {

	public String creationDate() {return "20141015";}


	private Service findScreenRect;
	private Rectangle screenRect;
	private Robot robot;
	

	public EntityImpl() throws Exception
	{
		findScreenRect = Outside.service(this,"gus.awt.screen.rect");
		screenRect = (Rectangle) findScreenRect.g();
		robot = new Robot();
	}

	public Object g() throws Exception
	{return robot.createScreenCapture(screenRect);}
	
	public Object t(Object obj) throws Exception
	{return robot.createScreenCapture((Rectangle) obj);}
}
