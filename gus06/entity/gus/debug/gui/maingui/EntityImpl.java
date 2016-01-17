package gus06.entity.gus.debug.gui.maingui;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140919";}


	private Service sysoutViewer;
	private Service syserrViewer;
	private Service syspropViewer;
	
	private Service threadViewer;
	private Service exceptionViewer;
	private Service libraryViewer;
	private Service mainViewer;
	
	private Service appJarViewer;
	private Service callTester;
	private Service exitButton;
	
	private JTabbedPane tab;

	public EntityImpl() throws Exception
	{
		sysoutViewer = Outside.service(this,"*gus.system.out.gui.viewer");
		syserrViewer = Outside.service(this,"*gus.system.err.gui.viewer");
		syspropViewer = Outside.service(this,"*gus.system.prop.gui.viewer");
		
		threadViewer = Outside.service(this,"*gus.thread.gui.viewer");
		exceptionViewer = Outside.service(this,"*gus.exception.gui.viewer");
		libraryViewer = Outside.service(this,"*gus.app.library.gui.displaygui");
		mainViewer = Outside.service(this,"*gus.app.main.gui.viewer");
		
		appJarViewer = Outside.service(this,"*gus.app.jarfile.gui.viewer");
		callTester = Outside.service(this,"*gus.debug.gui.calltester");
		exitButton = Outside.service(this,"gus.swing.button.build.exitbutton");
		
		
		tab = new JTabbedPane();
		
		tab.addTab("System.out",(JComponent) sysoutViewer.i());
		tab.addTab("System.err",(JComponent) syserrViewer.i());
		tab.addTab("System.prop",(JComponent) syspropViewer.i());
		
		tab.addTab("Thread",(JComponent) threadViewer.i());
		tab.addTab("Exceptions",(JComponent) exceptionViewer.i());
		tab.addTab("Libraries",(JComponent) libraryViewer.i());
		tab.addTab("Main map",(JComponent) mainViewer.i());
		tab.addTab("App jar",(JComponent) appJarViewer.i());
		tab.addTab("Call tester",(JComponent) callTester.i());
		tab.addTab("Exit",(JComponent) exitButton.i());
	}
	
	
	public Object i() throws Exception
	{return tab;}
}
