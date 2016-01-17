package gus06.entity.gus.web.isbndb.api.author.perform;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150509";}

	public static final String TYPE = "type";
	public static final String DATA = "author";

	private Service perform;
	

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.web.isbndb.api.perform");
	}
	
	public Object t(Object obj) throws Exception
	{
		Map map = (Map) obj;
		map.put(TYPE,DATA);
		return perform.t(map);
	}
}
