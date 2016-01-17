package gus06.entity.gus.file.read.image.from.txt;

import java.awt.image.BufferedImage;
import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150616";}

	
	private Service readTextFile;
	private Service textToImage;
	
	
	public EntityImpl() throws Exception
	{
		readTextFile = Outside.service(this,"gus.file.read.string.autodetect");
		textToImage = Outside.service(this,"gus.awt.bufferedimage.build.fromtext1");
	}
	


	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		if(!file.exists()) return null;
		
		String text = readTextFile(file);
		return textToImage(text);
	}
	
	
	
	private String readTextFile(File file) throws Exception
	{return (String) readTextFile.t(file);}
	
	
	private BufferedImage textToImage(String text) throws Exception
	{return (BufferedImage) textToImage.t(text);}
}
