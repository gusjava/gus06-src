package gus06.entity.gus.awt.screen.rect;

import gus06.framework.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsConfiguration;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20161006";}

	
	
	public Object g() throws Exception
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
		GraphicsConfiguration gc = device.getDefaultConfiguration();
		return gc.getBounds();
	}
}
