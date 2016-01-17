package gus06.entity.gus.time.now.yyyymm;

import java.text.SimpleDateFormat;
import java.util.Date;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20151103";}


	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	
	
	public Object g() throws Exception
	{return sdf.format(new Date());}
}
