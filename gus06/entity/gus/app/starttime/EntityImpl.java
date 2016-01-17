package gus06.entity.gus.app.starttime;

import java.text.SimpleDateFormat;
import java.util.Date;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140703";}

	
	private String timeStamp;

	public EntityImpl() throws Exception
	{
		Date date = (Date) Outside.resource(this,"main.starttime");
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(date);
	}
	
	
	public Object g() throws Exception
	{return timeStamp;}
}
