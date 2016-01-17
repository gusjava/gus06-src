package gus06.entity.gus.string.transform.format.timestamp.fr3;

import gus06.framework.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141106";}


	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	private Service stringToDate;


	public EntityImpl() throws Exception
	{stringToDate = Outside.service(this,"gus.convert.stringtodate");}
	
	
	public Object t(Object obj) throws Exception
	{
		Date d = (Date) stringToDate.t(obj);
		return sdf.format(d);
	}
}
