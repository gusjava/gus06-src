package gus06.entity.gus.awt.bufferedimage.color.avg.rgb;

import gus06.framework.*;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141122";}

	
	public Object t(Object obj) throws Exception
	{
		BufferedImage image = (BufferedImage) obj;
		
		int width = image.getWidth();
		int heigth = image.getHeight();
		
		double r = 0;
		double g = 0;
		double b = 0;
		
		for(int i=0;i<width;i++) for(int j=0;j<heigth;j++)
		{
			int rgb = image.getRGB(i,j);
			Color c = new Color(rgb);
			
			r += c.getRed();
			g += c.getGreen();
			b += c.getBlue();
		}
		
		double nb = width*heigth;
		int r_av = (int) (r/nb);
		int g_av = (int) (g/nb);
		int b_av = (int) (b/nb);
		
		return new Color(r_av,g_av,b_av);
	}
}
