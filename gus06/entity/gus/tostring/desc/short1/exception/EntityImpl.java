package gus06.entity.gus.tostring.desc.short1.exception;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160612";}
	


	public Object t(Object obj) throws Exception
	{
		Exception exp = (Exception) obj;
		return exp.toString();
	}
}
