package gus06.entity.gus.file.read.image.jai;

import java.io.File;
import javax.media.jai.JAI;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150616";}


	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		return JAI.create("fileload",file.getAbsolutePath());
	}
}
