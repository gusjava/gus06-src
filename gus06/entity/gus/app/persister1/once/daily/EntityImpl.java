package gus06.entity.gus.app.persister1.once.daily;

import gus06.framework.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20170320";}
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");


	private Service persister1;

	public EntityImpl() throws Exception
	{
		persister1 = Outside.service(this,"gus.app.persister1.once");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		String key = obj+"_"+today();
		return persister1.f(key);
	}
	
	private String today()
	{return sdf.format(new Date());}
}
