package gus06.entity.gus.file.write.ico;

import java.awt.image.BufferedImage;
import java.io.File;
import gus06.framework.*;
import java.io.FileOutputStream;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150607";}

	private Service toBufferedImage;

	public EntityImpl() throws Exception
	{toBufferedImage = Outside.service(this,"gus.find.bufferedimage");}


	public void p(Object obj) throws Exception
	{
		Object[] t = (Object[]) obj;
		if(t.length!=2) throw new Exception("Wrong data number: "+t.length);

		File file = (File) t[0];
		BufferedImage im = (BufferedImage) toBufferedImage.t(t[1]);
		
		FileOutputStream fos = new FileOutputStream(file);
		ICOEncoder.write(im,32,fos);
		fos.close();
	}
}
