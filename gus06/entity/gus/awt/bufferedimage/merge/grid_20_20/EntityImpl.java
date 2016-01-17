package gus06.entity.gus.awt.bufferedimage.merge.grid_20_20;

import gus06.framework.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141114";}

	public static final int X = 20;
	public static final int Y = 20;

	public Object t(Object obj) throws Exception
	{
		BufferedImage[] im = (BufferedImage[]) obj;
		if(im.length!=X*Y) throw new Exception("Wrong image number for merging inside grid "+X+" "+Y);
		
		int w = im[0].getWidth();
		int h = im[0].getHeight();
		
		for(int i=0;i<im.length;i++)
		{
			if(im[i].getWidth()!=w) throw new Exception("Invalid width for image at index "+i);
			if(im[i].getHeight()!=h) throw new Exception("Invalid heigth for image at index "+i);
		}
		
		BufferedImage image = new BufferedImage(w*X, h*Y, BufferedImage.TYPE_INT_ARGB);;
		Graphics g = image.getGraphics();
		
		for(int i=0;i<X;i++) for(int j=0;j<Y;j++)
		g.drawImage(im[j*X+i],i*w,j*h,null);
		
		return image;
	}
}
