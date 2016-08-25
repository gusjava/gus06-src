package gus06.entity.gus.time.date.weekofyear;

import gus06.framework.*;
import java.util.Date;
import java.util.Calendar;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160801";}
	
	
	public Object t(Object obj) throws Exception
	{
		Date date = (Date) obj;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int c = calendar.get(Calendar.WEEK_OF_YEAR);
		
		return new Integer(c);
	}
}
