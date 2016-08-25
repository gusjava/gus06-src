package gus06.entity.gus.time.date.is.weekend;

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
		
		int c = calendar.get(Calendar.DAY_OF_WEEK);
		return c==Calendar.SATURDAY || c==Calendar.SUNDAY;
	}
}
