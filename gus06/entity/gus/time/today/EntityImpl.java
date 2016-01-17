package gus06.entity.gus.time.today;

import java.text.SimpleDateFormat;
import java.util.Date;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140706";}


	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	
	public Object g() throws Exception
	{return sdf.format(new Date());}
}
