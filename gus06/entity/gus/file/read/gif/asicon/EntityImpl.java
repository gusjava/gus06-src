package gus06.entity.gus.file.read.gif.asicon;

import java.io.File;
import javax.swing.ImageIcon;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160208";}

	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		if(!file.exists()) return null;
		return new ImageIcon(file.toURI().toURL());
	}
}
