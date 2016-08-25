package gus06.entity.gus.time.date.next.year;

import gus06.framework.*;
import java.util.Date;
import java.util.Calendar;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160622";}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Date date = (Date) obj;
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.roll(Calendar.YEAR,1);
		return c.getTime();
	}
}
