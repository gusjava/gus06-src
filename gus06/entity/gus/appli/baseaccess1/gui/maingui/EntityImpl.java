package gus06.entity.gus.appli.baseaccess1.gui.maingui;

import gus06.framework.*;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150329";}

	private Service tab;
	private Service persist;
	
	private Service typeDirGui;
	private Service typeJdbcGui;
	private Service settingJdbcGui;
	private Service debugGui;

	

	public EntityImpl() throws Exception
	{
		tab = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		persist = Outside.service(this,"gus.swing.tabbedpane.persister.tab");
		
		typeDirGui = Outside.service(this,"gus.appli.baseaccess1.gui.type.dir");
		typeJdbcGui = Outside.service(this,"gus.appli.baseaccess1.gui.type.jdbc");
		settingJdbcGui = Outside.service(this,"gus.sys.base1.holder.jdbc.g.infos");
		debugGui = Outside.service(this,"*gus.debug.gui.maingui");
		
		
		tab.v("Base DIR",typeDirGui.i());
		tab.v("Base JDBC",typeJdbcGui.i());
		tab.v("Config JDBC",settingJdbcGui.i());
		tab.v("Debug",debugGui.i());
		
		persist.v(getClass().getName()+"_tab",tab.i());
	}
	
	
	public Object i() throws Exception
	{return tab.i();}
}
