package gus06.entity.gus.time.date.is.d.sunday;

import gus06.framework.*;
import java.util.Date;
import java.util.Calendar;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20160614";}
	

	
	public boolean f(Object obj) throws Exception
	{
		Date date = (Date) obj;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		return calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY;
	}
}
