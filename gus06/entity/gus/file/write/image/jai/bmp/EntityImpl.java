package gus06.entity.gus.file.write.image.jai.bmp;

import java.io.File;
import java.io.FileOutputStream;
import java.awt.image.RenderedImage;
import javax.media.jai.JAI;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150929";}
	
	public static final String TYPE = "BMP";


	private Service findRenderedImage;

	public EntityImpl() throws Exception
	{
		findRenderedImage = Outside.service(this,"gus.find.renderedimage");
	}



	public void p(Object obj) throws Exception
	{
		Object[] t = (Object[]) obj;
		if(t.length!=2) throw new Exception("Wrong data number: "+t.length);

		File file = (File) t[0];
		RenderedImage image = (RenderedImage) findRenderedImage.t(t[1]);
		
		FileOutputStream stream = new FileOutputStream(file);
		JAI.create("encode", image, stream, TYPE, null);
		JAI.create("filestore", image, file.getAbsolutePath(), TYPE, null);
		
		stream.close();
		/*
		 * Le fichier file reste vérouillé par l'application Java ......
		 */
	}
}
