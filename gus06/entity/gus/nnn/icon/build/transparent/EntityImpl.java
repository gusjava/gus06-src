package gus06.entity.gus.nnn.icon.build.transparent;

import gus06.framework.*;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Composite;
import java.awt.AlphaComposite;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150410";}

	public static final Composite ALPHA = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.48f);
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		Icon icon = (Icon) obj;
		
		int w = icon.getIconWidth();
		int h = icon.getIconHeight();
		
		BufferedImage image = createImage(w,h);
		Graphics2D g = image.createGraphics();
		g.setComposite(ALPHA);
		icon.paintIcon(null,g,0,0);
		g.dispose();
		
		return new ImageIcon(image);
	}
	
	
	private BufferedImage createImage(int w, int h)
	{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsConfiguration gc = ge.getDefaultScreenDevice().getDefaultConfiguration();
		return gc.createCompatibleImage(w,h,Transparency.BITMASK);
	}
}
