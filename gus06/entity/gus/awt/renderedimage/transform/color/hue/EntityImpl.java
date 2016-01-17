package gus06.entity.gus.awt.renderedimage.transform.color.hue;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import gus06.framework.*;

public class EntityImpl implements Entity, T, V {

	public String creationDate() {return "20151004";}

	
	private float hue;
	
	
	private Service toBufferedImage;
	private Service findHueValue;
	
	
	public EntityImpl() throws Exception
	{
		toBufferedImage = Outside.service(this,"gus.image.convert.tobufferedimage");
		findHueValue = Outside.service(this,"gus.app.find.findcolor.huevalue");
	}
	
	
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("hue")) {hue = findHue(obj);return;}
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	private float findHue(Object obj) throws Exception
	{
		String s = (String) findHueValue.t(obj);
		return Float.parseFloat(s);
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
			
			float[] hsb = Color.RGBtoHSB(c.getRed(),c.getGreen(),c.getBlue(),null);
			float saturation = hsb[1];
			float brightness = hsb[2];
			
			g.setColor(Color.getHSBColor(hue,saturation,brightness));
			g.drawRect(i,j,0,0);
		}
		g.dispose();
		return buffImg;
	}
	
	
	
}
