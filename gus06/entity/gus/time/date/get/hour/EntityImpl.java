package gus06.entity.gus.time.date.get.hour;

import gus06.framework.*;
import java.util.Date;
import java.util.Calendar;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160625";}
	
	
	public Object t(Object obj) throws Exception
	{
		Date date = (Date) obj;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int c = calendar.get(Calendar.HOUR_OF_DAY);
		
		return new Integer(c);
	}
}
