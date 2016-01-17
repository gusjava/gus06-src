package gus06.entity.gus.system.prop.init;

import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;

public class EntityImpl implements Entity {

	public String creationDate() {return "20141022";}


	private Map prop;

	public EntityImpl() throws Exception
	{
		prop = (Map) Outside.resource(this,"prop");
		
		Iterator it = prop.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			if(key.startsWith("sysprop."))
			{
				String value = (String) prop.get(key);
				System.setProperty(key.substring(8),value);
			}
		}
	}
}
