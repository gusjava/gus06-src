package gus06.entity.gus.awt.renderedimage.transform.color.darker;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151004";}

	
	private Service toBufferedImage;
	
	public EntityImpl() throws Exception
	{
		toBufferedImage = Outside.service(this,"gus.image.convert.tobufferedimage");
	}


	public Object t(Object obj) throws Exception
	{
		BufferedImage image = (BufferedImage) toBufferedImage.t(obj);
		int width = image.getWidth();
		int heigth = image.getHeight();
		
		BufferedImage buffImg = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		
		for(int i=0;i<width;i++) for(int j=0;j<heigth;j++)
		{
			int rgb = image.getRGB(i,j);
			Color c = new Color(rgb);
			
			g.setColor(c.darker());
			g.drawRect(i,j,1,1);
		}
		g.dispose();
		return buffImg;
	}
}
