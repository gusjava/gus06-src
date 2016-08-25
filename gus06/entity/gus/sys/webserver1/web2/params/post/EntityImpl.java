package gus06.entity.gus.sys.webserver1.web2.params.post;

import gus06.framework.*;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140930";}


	private Service stringToMap;

	public EntityImpl() throws Exception
	{stringToMap = Outside.service(this,"gus.map.string.stringtomap.builder3.urldecoding");}
	
	
	public Object t(Object obj) throws Exception
	{
		String body = (String) obj;
		
		if(body.equals("")) return new HashMap();
		return stringToMap.t(body);
	}
}
