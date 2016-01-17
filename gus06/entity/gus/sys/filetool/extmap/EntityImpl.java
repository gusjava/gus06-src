package gus06.entity.gus.sys.filetool.extmap;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, G, R {

	public String creationDate() {return "20150324";}

	public static final String EXT_CONSOLE = "gus.sys.filetool.ext.console";
	public static final String EXT_SEARCH1 = "gus.sys.filetool.ext.search1";
	public static final String EXT_BASE1 = "gus.sys.filetool.ext.base1";
	public static final String EXT_SYMFONY1 = "gus.sys.filetool.ext.symfony1";
	public static final String EXT_RUNTASK1 = "gus.sys.filetool.ext.runtask1";
	public static final String EXT_REPARTITION1 = "gus.sys.filetool.ext.repartition1";
	
	
	public static final String[] LIST = new String[]{
		EXT_CONSOLE,EXT_SEARCH1,EXT_BASE1,EXT_SYMFONY1,EXT_RUNTASK1,EXT_REPARTITION1
	};
	
	
	private Map map;

	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("console",EXT_CONSOLE);
		put("search",EXT_SEARCH1);
		put("base",EXT_BASE1);
		put("symfony",EXT_SYMFONY1);
		put("repartition",EXT_REPARTITION1);
	}
	
	
	
	
	
	public Object g() throws Exception
	{return LIST;}
	
	
	public Object r(String key) throws Exception
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
	
	private void put(String key, String value)
	{map.put(key,value);}
}
