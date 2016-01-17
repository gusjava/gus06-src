package gus06.entity.gus.awt.bufferedimage.create;

import gus06.framework.*;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.Dimension;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140803";}


	private Service toDim;
	
	public EntityImpl() throws Exception
	{toDim = Outside.service(this,"gus.find.dimension");}

	
	
	public Object t(Object obj) throws Exception
	{
		Dimension dim = (Dimension) toDim.t(obj);
		return graphicsConf().createCompatibleImage(dim.width,dim.height,Transparency.BITMASK);
	}
	
	
	private GraphicsEnvironment graphicsEnv()
	{return GraphicsEnvironment.getLocalGraphicsEnvironment();}
	
	private GraphicsDevice graphicsDevice()
	{return graphicsEnv().getDefaultScreenDevice();}
	
	private GraphicsConfiguration graphicsConf()
	{return graphicsDevice().getDefaultConfiguration();}
}
