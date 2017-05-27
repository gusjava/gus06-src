package gus06.entity.gus.tostring.desc.short1.date;

import gus06.framework.*;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160612";}


	private Service dateToString;
	
	
	public EntityImpl() throws Exception
	{
		dateToString = Outside.service(this,"gus.time.date.yyyymmdd_hhmmss");
	}



	public Object t(Object obj) throws Exception
	{
		Date d = (Date) obj;
		return "Date: "+dateToString.t(d);
	}
}
