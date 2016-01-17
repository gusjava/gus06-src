package gus06.entity.gus.appli.gusclient1.gui.space.monitoring.jre;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150323";}


	private Service tabHolder;

	private Service charsetViewer;
	private Service libraryViewer;
	
	
	public EntityImpl() throws Exception
	{
		tabHolder = Outside.service(this,"*gus.swing.tabbedpane.holder1");
	
		charsetViewer = Outside.service(this,"*gus.charset.gui.displaygui");
		libraryViewer = Outside.service(this,"*gus.app.library.gui.displaygui");
		
		tabHolder.v("GUI_charset#Charset",charsetViewer.i());
		tabHolder.v("GUI_lib#Libraries",libraryViewer.i());
	}
	
	
	public Object i() throws Exception
	{return tabHolder.i();}
}
