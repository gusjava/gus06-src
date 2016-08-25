package gus06.entity.gus.time.date.int3.dayofweek.en;

import gus06.framework.*;
import java.util.Date;
import java.util.Calendar;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160618";}
	
	
	private Service dayOfWeek;
	private Service find;
	
	private String[] days;
	
	
	public EntityImpl() throws Exception
	{
		dayOfWeek = Outside.service(this,"gus.time.date.int3.dayofweek");
		find = Outside.service(this,"gus.data.time.days.name_en");
		
		days = (String[]) find.g();
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Integer n = (Integer) dayOfWeek.t(obj);
		return days[n.intValue()];
	}
}
