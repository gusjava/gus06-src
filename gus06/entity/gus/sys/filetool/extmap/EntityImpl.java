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
	public static final String EXT_LIBRARY1 = "gus.sys.filetool.ext.library1";
	public static final String EXT_IDEA1 = "gus.sys.filetool.ext.idea1";
	public static final String EXT_SCRIPTLAUNCHER1 = "gus.sys.filetool.ext.scriptlauncher1";
	public static final String EXT_APPMONITORING1 = "gus.sys.filetool.ext.appmonitoring1";
	public static final String EXT_JAVATOOLBOX1 = "gus.sys.filetool.ext.javatoolbox1";
	public static final String EXT_JAVACOMPILER1 = "gus.sys.filetool.ext.javacompiler1";
	public static final String EXT_JAVAPROJECT1 = "gus.sys.filetool.ext.javaproject1";
	public static final String EXT_DBVIEWER1 = "gus.sys.filetool.ext.dbviewer1";
	public static final String EXT_DIRSIZEVIEWER1 = "gus.sys.filetool.ext.dirsizeviewer1";
	public static final String EXT_DIREXTVIEWER1 = "gus.sys.filetool.ext.dirextviewer1";
	public static final String EXT_WEBSERVER1 = "gus.sys.filetool.ext.webserver1";
	public static final String EXT_GUIBUILDER1 = "gus.sys.filetool.ext.guibuilder1";
	
	
	public static final String[] LIST = new String[]{
		EXT_CONSOLE,
		EXT_SEARCH1,
		EXT_BASE1,
		EXT_SYMFONY1,
		EXT_RUNTASK1,
		EXT_REPARTITION1,
		EXT_LIBRARY1,
		EXT_IDEA1,
		EXT_SCRIPTLAUNCHER1,
		EXT_APPMONITORING1,
		EXT_JAVATOOLBOX1,
		EXT_JAVACOMPILER1,
		EXT_JAVAPROJECT1,
		EXT_DBVIEWER1,
		EXT_DIRSIZEVIEWER1,
		EXT_DIREXTVIEWER1,
		EXT_WEBSERVER1,
		EXT_GUIBUILDER1
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
		put("library",EXT_LIBRARY1);
		put("idea",EXT_IDEA1);
		put("scriptlauncher",EXT_SCRIPTLAUNCHER1);
		put("appmonitoring",EXT_APPMONITORING1);
		put("javatoolbox",EXT_JAVATOOLBOX1);
		put("javacompiler",EXT_JAVACOMPILER1);
		put("javaproject",EXT_JAVAPROJECT1);
		put("dbviewer",EXT_DBVIEWER1);
		put("dirsizeviewer",EXT_DIRSIZEVIEWER1);
		put("dirextviewer",EXT_DIREXTVIEWER1);
		put("webserver",EXT_WEBSERVER1);
		put("guibuilder",EXT_GUIBUILDER1);
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
