package gus06.entity.gus.time.date.month.en;

import gus06.framework.*;
import java.util.Date;
import java.util.Calendar;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160615";}
	
	
	private Service find;
	private String[] months;
	
	
	public EntityImpl() throws Exception
	{
		find = Outside.service(this,"gus.data.time.months.name_en");
		months = (String[]) find.g();
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Date date = (Date) obj;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int index = calendar.get(Calendar.MONTH);
		
		return months[index];
	}
}
