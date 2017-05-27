package gus06.entity.gus.app.info.gui.viewer;

import gus06.framework.*;
import javax.swing.JComponent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map;
import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140818";}

	public static final long LAPSE = 900;


	public static final String KEY_CURRENTTIME = "Current time";
	public static final String KEY_STARTTIME = "Start time";
	public static final String KEY_JARPATH = "Jar path";
	public static final String KEY_ARGSLINE = "Args line";
	public static final String KEY_PID = "Runtime pid";
	public static final String KEY_JAVAVER = "Java version";
	public static final String KEY_JAVAHOME = "Java home";
	public static final String KEY_AUTHOR = "Author";
	public static final String KEY_TITLE = "Title";
	public static final String KEY_VERSION = "Version";
	public static final String KEY_MANAGERID = "Manager id";
	public static final String KEY_ENTITYNB = "Entity number";
	public static final String KEY_BUILDID = "Build id";
	public static final String KEY_BUILDTIME = "Build time";
	public static final String KEY_JARTIME = "Jar time";
	public static final String KEY_JARMD5 = "Jar md5";
	
	public static final String PROP_BUILDID = "jar.buildid";
	public static final String PROP_BUILDTIME = "jar.buildtime";
	public static final String PROP_AUTHOR = "app.author.name";
	public static final String PROP_VERSION = "app.version";
	public static final String PROP_TITLE = "app.title";
	
	
	
	
	private Service formPanel;
	
	private Service getJarFile;
	private Service getJarMd5;
	private Service getArgsLine;
	private Service getStartTime;
	private Service getPid;
	private Service getJarTime;
	private Service getEntityNb;
	
	private Map prop;
	private String managerId;
	
	private Timer timer;
	private TimerTask task;

	
	
	public EntityImpl() throws Exception
	{
		formPanel = Outside.service(this,"*gus.swing.panel.formpanel.map");
		
		getJarFile = Outside.service(this,"gus.app.jarfile");
		getJarMd5 = Outside.service(this,"gus.app.jarfile.md5");
		getArgsLine = Outside.service(this,"gus.app.argsline");
		getStartTime = Outside.service(this,"gus.app.starttime");
		getPid = Outside.service(this,"gus.app.pid");
		getJarTime = Outside.service(this,"gus.app.outside.lastmodified.timestamp");
		getEntityNb = Outside.service(this,"gus.app.jarfile.listing.entities.nb");
		
		prop = (Map) Outside.resource(this,"prop");
		managerId = (String) Outside.resource(this,"main.managerid");
		
		
		String buildId = get(PROP_BUILDID);
		String buildTime = get(PROP_BUILDTIME);
		String author = get(PROP_AUTHOR);
		String version = get(PROP_VERSION);
		String title = get(PROP_TITLE);
		
		String javaVer = System.getProperty("java.runtime.version");
		String javaHome = System.getProperty("java.home");

		File jarFile = (File) getJarFile.g();
		String jarMd5 = (String) getJarMd5.g();
		String argsLine = (String) getArgsLine.g();
		String startTime = (String) getStartTime.g();
		String jarTime = (String) getJarTime.g();
		String pid = (String) getPid.g();
		String entityNb = (String) getEntityNb.g();
		
		
		put(KEY_TITLE,title);
		put(KEY_VERSION,version);
		putSep(KEY_AUTHOR,author);
		
		put(KEY_BUILDID,buildId);
		put(KEY_MANAGERID,managerId);
		put(KEY_ENTITYNB,entityNb);
		putSep(KEY_JARMD5,jarMd5);
		
		put(KEY_CURRENTTIME,now());
		put(KEY_STARTTIME,startTime);
		put(KEY_JARTIME,jarTime);
		putSep(KEY_BUILDTIME,buildTime);
		
		put(KEY_JARPATH,jarFile.getAbsolutePath());
		put(KEY_ARGSLINE,argsLine);
		put(KEY_JAVAHOME,javaHome);
		put(KEY_JAVAVER,javaVer);
		put(KEY_PID,pid);
		
		task = new TimerTask() {public void run() {updateGui();}};
		timer = new Timer("TIMER_"+getClass().getName());
		timer.schedule(task,new Date(),LAPSE);
	}
	
	
	public Object i() throws Exception
	{return formPanel.i();}
	
	
	
	private void put(String key, String value) throws Exception
	{formPanel.v(key,value);}
	
	private void putSep(String key, String value) throws Exception
	{formPanel.v("|"+key,value);}
	
	
	
	private String get(String key)
	{
		if(!prop.containsKey(key)) return "?";
		return (String) prop.get(key);
	}
	
	
	
	private void updateGui()
	{
		try{put(KEY_CURRENTTIME,now());}
		catch(Exception e) {Outside.err(this,"updateGui()",e);}
	}
	
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	private String now() {return sdf.format(new Date());}
}
