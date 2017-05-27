package gus06.entity.gus.convert.stringtodateformat;

import gus06.framework.*;
import java.text.SimpleDateFormat;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161120";}


	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		return new SimpleDateFormat(s);
	}
}
