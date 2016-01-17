package gus06.entity.gus.convert.stringtofile;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150626";}

	
	public Object t(Object obj) throws Exception
	{
		return new File((String) obj);
	}
}
