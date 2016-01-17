package gus06.entity.gus.awt.bufferedimage.distance.color;

import gus06.framework.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141122";}


	private Service imageToColor;
	private Service distance;


	public EntityImpl() throws Exception
	{
		imageToColor = Outside.service(this,"gus.awt.bufferedimage.color.avg.rgb.cache");
		distance = Outside.service(this,"gus.awt.color.distance.rgb");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		BufferedImage[] img = (BufferedImage[]) obj;
		if(img.length!=2) throw new Exception("Wrong data number: "+img.length);
		
		Color c1 = (Color) imageToColor.t(img[0]);
		Color c2 = (Color) imageToColor.t(img[1]);
		
    		return distance.t(new Color[]{c1,c2});
	}
}
