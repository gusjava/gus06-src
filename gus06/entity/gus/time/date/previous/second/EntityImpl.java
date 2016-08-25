package gus06.entity.gus.time.date.previous.second;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160622";}
	
	public static final long LAPSE = 1000L;
	
	
	public Object t(Object obj) throws Exception
	{
		Date d = (Date) obj;
		return new Date(d.getTime() - LAPSE);
	}
}
