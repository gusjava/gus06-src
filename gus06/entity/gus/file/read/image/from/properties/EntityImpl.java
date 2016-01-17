package gus06.entity.gus.file.read.image.from.properties;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150616";}

	
	private Service readProptFile;
	private Service propToImage;
	
	
	public EntityImpl() throws Exception
	{
		readProptFile = Outside.service(this,"gus.file.read.properties");
		propToImage = Outside.service(this,"gus.awt.bufferedimage.build.fromproperties1");
	}
	


	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		if(!file.exists()) return null;
		
		Map prop = readPropFile(file);
		return propToImage(prop);
	}
	
	
	
	private Map readPropFile(File file) throws Exception
	{return (Map) readProptFile.t(file);}
	
	
	private BufferedImage propToImage(Map text) throws Exception
	{return (BufferedImage) propToImage.t(text);}
}
