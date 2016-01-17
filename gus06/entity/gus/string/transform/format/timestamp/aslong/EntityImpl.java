package gus06.entity.gus.string.transform.format.timestamp.aslong;

import gus06.framework.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150920";}

	
	private Service stringToDate;


	public EntityImpl() throws Exception
	{stringToDate = Outside.service(this,"gus.convert.stringtodate");}
	
	
	public Object t(Object obj) throws Exception
	{
		Date d = (Date) stringToDate.t(obj);
		return ""+d.getTime();
	}
}
