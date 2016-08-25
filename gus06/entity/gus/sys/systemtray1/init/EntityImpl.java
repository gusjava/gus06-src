package gus06.entity.gus.sys.systemtray1.init;

import gus06.framework.*;
import java.io.PrintStream;
import java.awt.TrayIcon;
import java.awt.SystemTray;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.Action;

public class EntityImpl implements Entity, MouseListener {

	public String creationDate() {return "20160422";}


	private Service buildAppTray;
	private Service frameToggle;
	private Service getActionExit;
	private Service buildPopupMenu;
	
	private TrayIcon appTray;
	private JPopupMenu menu;
	private JFrame mainFrame;
	private PrintStream out;
	private Action actionExit;
	
	

	public EntityImpl() throws Exception
	{
		buildAppTray = Outside.service(this,"gus.sys.systemtray1.trayicon.app");
		frameToggle = Outside.service(this,"gus.sys.systemtray1.frametoggle");
		getActionExit = Outside.service(this,"gus.app.action.exit.en");
		buildPopupMenu = Outside.service(this,"gus.awt.trayicon.build.popupmenu1");
		
		mainFrame = (JFrame) Outside.resource(this,"mainframe");
		out = (PrintStream) Outside.resource(this,"sysout");
		actionExit = (Action) getActionExit.g();
		
		
		if(!SystemTray.isSupported())
		{
			out.println("SystemTray is not available: entity disabled");
			return;
		}
		
		
		appTray = (TrayIcon) buildAppTray.g();
		
		menu = (JPopupMenu) buildPopupMenu.t(appTray);
		menu.add(actionExit);
		
		SystemTray.getSystemTray().add(appTray);
		
		frameToggle.p(new Object[]{appTray,mainFrame});
		appTray.addMouseListener(this);
	}
	
	
	
	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
}
