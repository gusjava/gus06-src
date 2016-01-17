package gus06.entity.gus.awt.renderedimage.transform.color.blurvertical;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151004";}

	public static final int LIMIT = 7;
	
	
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

		int q = 0;
		int rgb = 0;
		
		for(int i=0;i<width;i++)		
		{
			q = 0;
			for(int j=0;j<heigth;j++)
			{
				if(q==0) rgb = image.getRGB(i,j);
				q++;if(q==LIMIT) q = 0;
				Color c = new Color(rgb);
				g.setColor(c);
				g.drawRect(i,j,1,1);
			}
		}
		g.dispose();
		return buffImg;
	}
}
