package gus06.entity.gus.convert.icontoimage;

import gus06.framework.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140803";}

	
	private Service createImage;
	
	public EntityImpl() throws Exception
	{createImage = Outside.service(this,"gus.awt.bufferedimage.create");}
	
	
	public Object t(Object obj) throws Exception
	{return iconToImage((Icon) obj);}
	
	
	
	private Image iconToImage(Icon icon) throws Exception
	{
		if(icon==null) return null;
		if(icon instanceof ImageIcon) return ((ImageIcon)icon).getImage();

		int w = icon.getIconWidth();
		int h = icon.getIconHeight();
		
		BufferedImage image = createImage(w,h);
		Graphics2D g = image.createGraphics();
		icon.paintIcon(null,g,0,0);
		g.dispose();
		return image;
	}
	
	
	private BufferedImage createImage(int w, int h) throws Exception
	{return (BufferedImage) createImage.t(new int[]{w,h});}
}
