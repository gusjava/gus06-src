package gus06.entity.gus.app.persister1.counter.daily;

import gus06.framework.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntityImpl implements Entity, R {

	public String creationDate() {return "20160420";}
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");


	private Service persister1;

	public EntityImpl() throws Exception
	{
		persister1 = Outside.service(this,"gus.app.persister1.counter");
	}
	
	
	public Object r(String key) throws Exception
	{
		String key1 = key+"_"+today();
		return persister1.r(key1);
	}
	
	private String today()
	{return sdf.format(new Date());}
}
