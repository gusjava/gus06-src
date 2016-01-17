package gus06.entity.gus.app.infomap;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140705";}


	public static final String KEY_STARTTIME = "a1:start time";
	public static final String KEY_JARPATH = "a2:jar path";
	public static final String KEY_ARGSLINE = "a3:args line";
	public static final String KEY_PID = "a4:runtime pid";
	public static final String KEY_JAVA = "a5:java version";
	
	public static final String KEY_MANAGERID = "b1:manager id";
	public static final String KEY_BUILDID = "b2:build id";
	public static final String KEY_BUILDTIME = "b3:build time";
	public static final String KEY_JARTIME = "b4:jar time";
	public static final String KEY_JARMD5 = "b5:jar md5";
	
	public static final String PROP_BUILDID = "jar.buildid";
	public static final String PROP_BUILDTIME = "jar.buildtime";
	
	
	
	private Service getJarFile;
	private Service getJarMd5;
	private Service getArgsLine;
	private Service getStartTime;
	private Service getPid;
	private Service getJarTime;
	
	private Map prop;
	private String managerId;
	
	private Map map;

	
	
	public EntityImpl() throws Exception
	{
		getJarFile = Outside.service(this,"gus.app.jarfile");
		getJarMd5 = Outside.service(this,"gus.app.jarfile.md5");
		getArgsLine = Outside.service(this,"gus.app.argsline");
		getStartTime = Outside.service(this,"gus.app.starttime");
		getPid = Outside.service(this,"gus.app.pid");
		getJarTime = Outside.service(this,"gus.app.outside.lastmodified");
		
		prop = (Map) Outside.resource(this,"prop");
		managerId = (String) Outside.resource(this,"main.managerid");
	}
	
	
	public Object g() throws Exception
	{
		if(map==null) init();
		return map;
	}
	
	
	
	private void init() throws Exception
	{
		map = new HashMap();
		
		String buildId = get(PROP_BUILDID);
		String buildTime = get(PROP_BUILDTIME);
		String java = System.getProperty("java.runtime.version");

		File jarFile = (File) getJarFile.g();
		String jarMd5 = (String) getJarMd5.g();
		String argsLine = (String) getArgsLine.g();
		String startTime = (String) getStartTime.g();
		String jarTime = (String) getJarTime.g();
		String pid = (String) getPid.g();
		
		map.put(KEY_BUILDID,buildId);
		map.put(KEY_BUILDTIME,buildTime);
		map.put(KEY_JARPATH,jarFile.getAbsolutePath());
		map.put(KEY_JARMD5,jarMd5);
		map.put(KEY_MANAGERID,managerId);
		map.put(KEY_ARGSLINE,argsLine);
		map.put(KEY_STARTTIME,startTime);
		map.put(KEY_JARTIME,jarTime);
		map.put(KEY_PID,pid);
		map.put(KEY_JAVA,java);
	}
	
	
	private String get(String key)
	{
		if(!prop.containsKey(key)) return "?";
		return (String) prop.get(key);
	}
}
