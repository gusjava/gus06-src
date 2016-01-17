package gus06.entity.gus.time.now;

import java.text.SimpleDateFormat;
import java.util.Date;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140703";}


	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	
	
	public Object g() throws Exception
	{return sdf.format(new Date());}
}
