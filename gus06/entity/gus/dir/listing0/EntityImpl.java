package gus06.entity.gus.dir.listing0;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150618";}


	public Object t(Object obj) throws Exception
	{
		File dir = (File) obj;
		return dir.listFiles();
	}
}
