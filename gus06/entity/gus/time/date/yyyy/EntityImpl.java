package gus06.entity.gus.time.date.yyyy;

import java.text.SimpleDateFormat;
import java.util.Date;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160612";}


	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	
	
	public Object t(Object obj) throws Exception
	{return sdf.format((Date) obj);}
}
