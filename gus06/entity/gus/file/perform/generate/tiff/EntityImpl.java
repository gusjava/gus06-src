package gus06.entity.gus.file.perform.generate.tiff;

import gus06.framework.*;
import java.io.File;
import java.awt.image.BufferedImage;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151113";}


	private Service fileToImage;
	private Service writeImage;


	public EntityImpl() throws Exception
	{
		fileToImage = Outside.service(this,"gus.file.read.image.generic");
		writeImage = Outside.service(this,"gus.file.write.image.tiff");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		BufferedImage img = (BufferedImage) fileToImage.t(o[0]);
		writeImage.p(new Object[]{o[1],img});
	}
}
