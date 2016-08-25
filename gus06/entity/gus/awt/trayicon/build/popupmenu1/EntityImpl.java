package gus06.entity.gus.awt.trayicon.build.popupmenu1;

import gus06.framework.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.TrayIcon;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160422";}
	
	public static final long LAPSE = 2000;


	private Timer timer;

	public EntityImpl() throws Exception
	{
		timer = new Timer("TIMER_"+getClass().getName());
	}

	
	
	public Object t(Object obj) throws Exception
	{
		TrayIcon tray = (TrayIcon) obj;
		JPopupMenu menu = new JPopupMenu();
		tray.addMouseListener(new PopupAdapter(menu));
		return menu;
	}
	
	
	
	private class PopupAdapter extends MouseAdapter
	{
		private JPopupMenu popup;
	
		public PopupAdapter(JPopupMenu popup) 
		{this.popup = popup;}
	
		public void mousePressed(MouseEvent e) {maybeShowPopup(e);}
		public void mouseReleased(MouseEvent e) {maybeShowPopup(e);}
	
		private void maybeShowPopup(MouseEvent e)
		{
			if(!e.isPopupTrigger()) return;
			popup.show(e.getComponent(),e.getX(),e.getY());
			
			TimerTask t = new TimerTask(){public void run() {popup.setVisible(false);}};
			timer.schedule(t,LAPSE);
		}
	}
}
