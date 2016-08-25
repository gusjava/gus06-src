package gus06.entity.gus.time.date.format.date.long1.fr;

import gus06.framework.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160809";}

	public static final DateFormat DATEFORMAT = DateFormat.getDateInstance(DateFormat.LONG,Locale.FRENCH);
	
	
	public Object t(Object obj) throws Exception
	{
		Date date = (Date) obj;
		if(date==null) return "";
		return DATEFORMAT.format(date);
	}
}