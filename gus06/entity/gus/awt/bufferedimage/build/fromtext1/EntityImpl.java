package gus06.entity.gus.awt.bufferedimage.build.fromtext1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import gus06.framework.*;

public class EntityImpl implements Entity, T, V {

	public String creationDate() {return "20150616";}

	
	public static final Font DEFAULT_FONT = new Font("Arial",Font.PLAIN,20);
	public static final int DEFAULT_MARGIN = 15;
	
	
	
	private Service drawText;
	private Service findDimension;

	private Font font = DEFAULT_FONT;
	private int margin = DEFAULT_MARGIN;
	
	
	
	public EntityImpl() throws Exception
	{
		drawText = Outside.service(this,"gus.graphics.draw.string.drawstring1");
		findDimension = Outside.service(this,"gus.graphics.draw.string.finddimension1");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("font")) {font = (Font) obj;return;}
		if(key.equals("margin")) {margin = Integer.parseInt((String) obj);return;}
		
		throw new Exception("Unknown key: "+key);
	}
	


	public Object t(Object obj) throws Exception
	{
		String text = (String) obj;
		
		int[] dim = findDim(text,font);
		
		int weight = dim[0] + 2*margin;
		int height = dim[1] + 2*margin;
		
		BufferedImage img = img(weight,height);
		Graphics2D g = img.createGraphics();
		
		g.setColor(Color.WHITE);
		g.fillRect(0,0,weight,height);
		
		g.setColor(Color.BLACK);
		//g.drawRect(margin,margin,dim[0],dim[1]);
		
		g.setFont(font);
		drawText(g,margin,margin,text);
		
		g.dispose();
		
		return img;
	}
	
	
	
	private int[] findDim(String text, Font font) throws Exception
	{return (int[]) findDimension.t(new Object[]{text,font});}
	
	
	private void drawText(Graphics2D g, int x, int y, String text) throws Exception
	{drawText.p(new Object[]{g,new Point(x,y),text});}
	
	
	private BufferedImage img(int w, int h)
	{return new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);}
}
