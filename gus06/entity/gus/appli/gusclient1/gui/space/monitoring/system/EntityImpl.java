package gus06.entity.gus.appli.gusclient1.gui.space.monitoring.system;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140808";}


	private Service tabHolder;

	private Service sysoutViewer;
	private Service syserrViewer;
	private Service syspropViewer;
	
	
	public EntityImpl() throws Exception
	{
		tabHolder = Outside.service(this,"*gus.swing.tabbedpane.holder1");
	
		sysoutViewer = Outside.service(this,"*gus.system.out.gui.viewer");
		syserrViewer = Outside.service(this,"*gus.system.err.gui.viewer");
		syspropViewer = Outside.service(this,"*gus.system.prop.gui.viewer");
		
		tabHolder.v("GUI_sysout#System.out",sysoutViewer.i());
		tabHolder.v("GUI_syserr#System.err",syserrViewer.i());
		tabHolder.v("GUI_sysprop#Prop / Env",syspropViewer.i());
	}
	
	
	public Object i() throws Exception
	{return tabHolder.i();}
}
