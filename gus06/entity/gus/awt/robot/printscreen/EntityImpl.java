package gus06.entity.gus.awt.robot.printscreen;

import gus06.framework.*;
import java.awt.*;

public class EntityImpl implements Entity, G, T {

	public String creationDate() {return "20141015";}


	
	private Rectangle screenRect;
	private Robot robot;
	

	public EntityImpl() throws AWTException
	{
		screenRect = getScreenRect();
		robot = new Robot();
	}

	public Object g() throws Exception
	{return robot.createScreenCapture(screenRect);}
	
	
	public Object t(Object obj) throws Exception
	{
		Rectangle rect = (Rectangle) obj;
		return robot.createScreenCapture(rect);
	}
	

	private Rectangle getScreenRect()
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
		GraphicsConfiguration gc = device.getDefaultConfiguration();
		return gc.getBounds();
	}
}
