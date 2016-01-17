package gus06.entity.gus.convert.iconstoicon;

import gus06.framework.*;
import java.awt.Image;
import javax.swing.ImageIcon;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140913";}


	private Service iconsToImage;


	public EntityImpl() throws Exception
	{
		iconsToImage = Outside.service(this,"gus.convert.iconstoimage");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Image image = (Image) iconsToImage.t(obj);
		return new ImageIcon(image);
	}
}
