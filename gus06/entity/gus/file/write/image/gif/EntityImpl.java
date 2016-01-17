package gus06.entity.gus.file.write.image.gif;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150620";}

	
	private Service toBufferedImage;
	private Service copyFile;
	
	public EntityImpl() throws Exception
	{
		toBufferedImage = Outside.service(this,"gus.find.bufferedimage");
		copyFile = Outside.service(this,"gus.file.op.copy");
	}
	


	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);

		File file = (File) o[0];
		File srcFile = findSrcFile(o[1]);
		
		if(srcFile!=null && srcFile.exists())
			copy(srcFile,file);
		else writeImageGif(file,o[1]);
	}
	
	
	
	
	private File findSrcFile(Object obj)
	{
		if(obj instanceof ImageIcon)
		{
			ImageIcon icon = (ImageIcon) obj;
			String desc = icon.getDescription().toLowerCase();
			if(desc.startsWith("file:/") && desc.endsWith(".gif"))
				return new File(desc.substring(6));
		}
		return null;
	}
	
	
	
	private void writeImageGif(File file, Object obj) throws Exception
	{
		BufferedImage im = toBufferedImage(obj);
		ImageIO.write(im,"gif",file);
	}
	
	
	
	private BufferedImage toBufferedImage(Object obj) throws Exception
	{return (BufferedImage) toBufferedImage.t(obj);}
	
	
	private void copy(File f1, File f2) throws Exception
	{copyFile.p(new File[]{f1,f2});}
}
