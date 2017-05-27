package gus06.entity.gus.sys.filetool.ext.appmonitoring1.holder;

import gus06.framework.*;
import javax.swing.JComponent;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20161107";}
	
	public static final String KEY_STRUCT = "struct";
	
	
	private Service findRoot;
	private Service tabHolder;

	private Service threadViewer;
	private Service exceptionViewer;
	private Service debugViewer;
	private Service systemViewer;
	private Service jreViewer;
	private Service mainViewer;
	private Service entitiesViewer;
	private Service infoViewer;
	private Service appJarViewer;
	
	
	
	private Map map;
	private File root;
	

	public EntityImpl() throws Exception
	{
		findRoot = Outside.service(this,"gus.sys.filetool.findroot");
		tabHolder = Outside.service(this,"*gus.swing.tabbedpane.holder1");
	
		threadViewer = Outside.service(this,"*gus.thread.gui.viewer");
		exceptionViewer = Outside.service(this,"*gus.exception.gui.viewer");
		debugViewer = Outside.service(this,"*gus.appli.gusclient1.gui.space.monitoring.debug");
		systemViewer = Outside.service(this,"*gus.appli.gusclient1.gui.space.monitoring.system");
		jreViewer = Outside.service(this,"*gus.appli.gusclient1.gui.space.monitoring.jre");
		mainViewer = Outside.service(this,"*gus.appli.gusclient1.gui.space.monitoring.main");
		entitiesViewer = Outside.service(this,"*gus.appli.gusclient1.gui.space.monitoring.entities");
		infoViewer = Outside.service(this,"*gus.app.info.gui.viewer");
		appJarViewer = Outside.service(this,"*gus.app.jarfile.gui.viewer");
	}
	
	
	public Object i() throws Exception
	{return tabHolder.i();}
	
	
	
	public void p(Object obj) throws Exception
	{
		map = (Map) obj;
		root = (File) findRoot.t(map);
		
		String struct = get(KEY_STRUCT);
		if(struct==null) {buildDefault();return;}
		
		String[] nn = struct.split(";");
		for(String n:nn) build(n);
	}
	
	
	private void buildDefault() throws Exception
	{
		tabHolder.v("Threads",threadViewer.i());
		tabHolder.v("Exceptions",exceptionViewer.i());
		tabHolder.v("Debug",debugViewer.i());
		tabHolder.v("System",systemViewer.i());
		tabHolder.v("JRE",jreViewer.i());
		tabHolder.v("Main",mainViewer.i());
		tabHolder.v("Entities",entitiesViewer.i());
		tabHolder.v("Infos",infoViewer.i());
		tabHolder.v("App jar",appJarViewer.i());
	}
	
	
	private void build(String id) throws Exception
	{
		if(id.equals("threads"))		addTab(id,"Threads",threadViewer);
		else if(id.equals("exceptions"))	addTab(id,"Exceptions",exceptionViewer);
		else if(id.equals("debug"))		addTab(id,"Debug",debugViewer);
		else if(id.equals("system"))		addTab(id,"System",systemViewer);
		else if(id.equals("jre"))		addTab(id,"JRE",jreViewer);
		else if(id.equals("main"))		addTab(id,"Main",mainViewer);
		else if(id.equals("entities"))		addTab(id,"Entities",entitiesViewer);
		else if(id.equals("infos"))		addTab(id,"Infos",infoViewer);
		else if(id.equals("appjar"))		addTab(id,"App jar",appJarViewer);
	}
	
	
	private void addTab(String id, String display0, Service s) throws Exception
	{
		String display = get(id+".display");
		if(display==null) display = display0;
		tabHolder.v(display,s.i());
	}
	
	
	private String get(String key) throws Exception
	{
		if(map==null) return null;
		if(!map.containsKey(key)) return null;
		return (String) map.get(key);
	}
}
