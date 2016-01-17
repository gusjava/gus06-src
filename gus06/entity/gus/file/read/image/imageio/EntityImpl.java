package gus06.entity.gus.file.read.image.imageio;

import gus06.framework.*;
import java.io.File;
import javax.imageio.ImageIO;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140909";}
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		return ImageIO.read(file); 
	}
}
