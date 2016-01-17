package gus06.entity.gus.awt.bufferedimage.create.white;

import gus06.framework.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141115";}


	private Service create;


	public EntityImpl() throws Exception
	{
		create = Outside.service(this,"gus.awt.bufferedimage.create");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		BufferedImage img = (BufferedImage) create.t(obj);
		Graphics2D g = img.createGraphics();  
		g.setColor(Color.WHITE);  
		g.fillRect(0,0,img.getWidth(),img.getHeight());  
		return img;
	}
}
