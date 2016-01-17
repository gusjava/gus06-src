package gus06.entity.gus.string.transform.format.timestamp.locale.french;

import gus06.framework.*;
import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150215";}
	
	private Service stringToDate;
	private DateFormat dateFormatter;
	

	public EntityImpl() throws Exception
	{
		stringToDate = Outside.service(this,"gus.convert.stringtodate");
		dateFormatter = DateFormat.getDateInstance(DateFormat.LONG,Locale.FRENCH);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Date d = (Date) stringToDate.t(obj);
		return dateFormatter.format(d);
	}
}
