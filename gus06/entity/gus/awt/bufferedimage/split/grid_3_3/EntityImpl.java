package gus06.entity.gus.awt.bufferedimage.split.grid_3_3;

import gus06.framework.*;
import java.awt.image.BufferedImage;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141122";}

	public static final int X = 3;
	public static final int Y = 3;
	
	public Object t(Object obj) throws Exception
	{
		BufferedImage image = (BufferedImage) obj;
		BufferedImage[] im = new BufferedImage[X*Y];
		
		int image_w = image.getWidth();
		int image_h = image.getHeight();
		
		int x = 0;
		int y = 0;
		
		int w = image_w/X;
		int h = image_h/Y;
		
		for(int i=0;i<X*Y;i++)
		{
			im[i] = image.getSubimage(x,y,Math.min(w,image_w-x),Math.min(h,image_h-y));
			x += w;
			
			if((i+1)%X == 0) {x = 0;y += h;}
		}
		return im;
	}
}
