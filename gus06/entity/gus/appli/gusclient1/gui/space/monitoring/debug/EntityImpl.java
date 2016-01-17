package gus06.entity.gus.appli.gusclient1.gui.space.monitoring.debug;

import gus06.framework.*;
import javax.swing.JComponent;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140814";}


	private Service tabHolder;

	private Service serviceWatcher;
	private Service callTester;
	
	
	public EntityImpl() throws Exception
	{
		tabHolder = Outside.service(this,"*gus.swing.tabbedpane.holder1");
	
		serviceWatcher = Outside.service(this,"*gus.maincust.service.wrapper1.gui");
		callTester = Outside.service(this,"*gus.debug.gui.calltester");
		
		tabHolder.v("Call tester",(JComponent) callTester.i());
		tabHolder.v("Service watcher",(JComponent) serviceWatcher.i());
	}
	
	
	public Object i() throws Exception
	{return tabHolder.i();}
}
