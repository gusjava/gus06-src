package gus06.entity.gus.convert.iconstoimage;

import gus06.framework.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140913";}

	
	private Service createImage;
	
	public EntityImpl() throws Exception
	{createImage = Outside.service(this,"gus.awt.bufferedimage.create");}
	
	
	public Object t(Object obj) throws Exception
	{return iconsToImage((Icon[]) obj);}
	
	
	
	private Image iconsToImage(Icon[] icons) throws Exception
	{
		if(icons==null) return null;
		
		int w = 0;
		int h = 0;
		
		for(Icon icon:icons) if(icon!=null)
		{
			w = Math.max(w,icon.getIconWidth());
			h = Math.max(h,icon.getIconHeight());
		}
		
		BufferedImage image = createImage(w,h);
		Graphics2D g = image.createGraphics();
		
		for(Icon icon:icons) if(icon!=null)
		icon.paintIcon(null,g,0,0);
		
		g.dispose();
		return image;
	}
	
	
	
	private BufferedImage createImage(int w, int h) throws Exception
	{return (BufferedImage) createImage.t(new int[]{w,h});}
}
