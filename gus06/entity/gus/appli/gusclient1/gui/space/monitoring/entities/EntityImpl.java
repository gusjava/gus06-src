package gus06.entity.gus.appli.gusclient1.gui.space.monitoring.entities;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140808";}


	private Service tabHolder;

	private Service entityMapViewer;
	private Service classMapViewer;
	private Service jarMapViewer;
	
	
	public EntityImpl() throws Exception
	{
		tabHolder = Outside.service(this,"*gus.swing.tabbedpane.holder1");
	
		entityMapViewer = Outside.service(this,"*gus.app.entitymap.gui.viewer");
		classMapViewer = Outside.service(this,"*gus.app.classmap.gui.viewer");
		jarMapViewer = Outside.service(this,"*gus.app.jarmap.gui.viewer");
		
		tabHolder.v("GUI_entityObj#Object map",entityMapViewer.i());
		tabHolder.v("GUI_entityClass#Class map",classMapViewer.i());
		tabHolder.v("GUI_entityJar#Jar map",jarMapViewer.i());
	}
	
	
	public Object i() throws Exception
	{return tabHolder.i();}
}
