package gus06.entity.gus.feature.call.i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140907";}


	public Object t(Object obj) throws Exception
	{return ((I) obj).i();}
}
