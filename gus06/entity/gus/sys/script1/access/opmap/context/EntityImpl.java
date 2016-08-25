package gus06.entity.gus.sys.script1.access.opmap.context;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160805";}

	public static final String KEY_CONTEXT = "__context";
	
	
	public Object t(Object obj) throws Exception
	{
		Map opMap = (Map) obj;
		G wrapper = (G) opMap.get(KEY_CONTEXT);
		return wrapper.g();
	}
}
