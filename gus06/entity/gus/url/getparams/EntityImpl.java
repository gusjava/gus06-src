package gus06.entity.gus.url.getparams;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170130";}


	private Service stringToMap;

	public EntityImpl() throws Exception
	{stringToMap = Outside.service(this,"gus.map.string.stringtomap.builder3.urldecoding");}

	
	public Object t(Object obj) throws Exception
	{
		URL url = (URL) obj;
		String[] n = url.getFile().split("\\?",2);
		if(n.length==1) return null;
		return stringToMap.t(n[1]);
	}
}
