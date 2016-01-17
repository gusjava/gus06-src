package gus06.entity.gus.time.now.pattern;

import java.text.SimpleDateFormat;
import java.util.Date;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141002";}


	public Object t(Object obj) throws Exception
	{
		String pattern = (String) obj;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
}
