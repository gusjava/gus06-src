package gus06.entity.gus.app.outside.lastmodified.timestamp;

import gus06.framework.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20170411";}

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");


	private Service find;

	public EntityImpl() throws Exception
	{
		find = Outside.service(this,"gus.app.outside.lastmodified");
	}
	
	public Object g() throws Exception
	{
		Date date = (Date) find.g();
		return sdf.format(date);
	}
}
