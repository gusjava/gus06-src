package gus06.entity.gus.appli.gusclient1.gui.space.monitoring;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140719";}


	private Service tabHolder;
	private Service tabPersist;

	private Service threadViewer;
	private Service exceptionViewer;
	private Service debugViewer;
	private Service systemViewer;
	private Service jreViewer;
	private Service mainViewer;
	private Service entitiesViewer;
	private Service infoViewer;
	private Service appJarViewer;
	
	
	public EntityImpl() throws Exception
	{
		tabHolder = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		tabPersist = Outside.service(this,"gus.swing.tabbedpane.persister.tab");
	
		threadViewer = Outside.service(this,"*gus.thread.gui.viewer");
		exceptionViewer = Outside.service(this,"*gus.exception.gui.viewer");
		debugViewer = Outside.service(this,"*gus.appli.gusclient1.gui.space.monitoring.debug");
		systemViewer = Outside.service(this,"*gus.appli.gusclient1.gui.space.monitoring.system");
		jreViewer = Outside.service(this,"*gus.appli.gusclient1.gui.space.monitoring.jre");
		mainViewer = Outside.service(this,"*gus.appli.gusclient1.gui.space.monitoring.main");
		entitiesViewer = Outside.service(this,"*gus.appli.gusclient1.gui.space.monitoring.entities");
		infoViewer = Outside.service(this,"*gus.app.info.gui.viewer");
		appJarViewer = Outside.service(this,"*gus.app.jarfile.gui.viewer");
		
		tabHolder.v("GUI_thread#Threads",threadViewer.i());
		tabHolder.v("GUI_exception#Exceptions",exceptionViewer.i());
		tabHolder.v("GUI_debug#Debug",debugViewer.i());
		tabHolder.v("GUI_system#System",systemViewer.i());
		tabHolder.v("GUI_jre#JRE",jreViewer.i());
		tabHolder.v("GUI_main#Main",mainViewer.i());
		tabHolder.v("entity#Entities",entitiesViewer.i());
		tabHolder.v("GUI_info#Info",infoViewer.i());
		tabHolder.v("GUI_jarFile#App jar",appJarViewer.i());
		
		tabPersist.v(getClass().getName()+"_tab",tabHolder.i());
	}
	
	
	public Object i() throws Exception
	{return tabHolder.i();}
}
