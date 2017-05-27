package gus06.entity.gus.sys.ruleobj1.build.file;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170117";}

	
	public Object t(Object obj) throws Exception
	{
		return new File((String) obj);
	}
}
