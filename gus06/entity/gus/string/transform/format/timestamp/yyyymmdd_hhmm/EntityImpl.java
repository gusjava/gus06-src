package gus06.entity.gus.string.transform.format.timestamp.yyyymmdd_hhmm;

import gus06.framework.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150920";}


	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmm");
	
	private Service stringToDate;


	public EntityImpl() throws Exception
	{stringToDate = Outside.service(this,"gus.convert.stringtodate");}
	
	
	public Object t(Object obj) throws Exception
	{
		Date d = (Date) stringToDate.t(obj);
		return sdf.format(d);
	}
}
