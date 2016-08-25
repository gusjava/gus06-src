package gus06.entity.gus.sys.systemtray1.frametoggle;

import gus06.framework.*;
import java.awt.TrayIcon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

public class EntityImpl implements Entity, T, P {

	public String creationDate() {return "20160422";}


	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		TrayIcon tray = (TrayIcon) o[0];
		JFrame frame = (JFrame) o[1];
		
		return new Holder(tray,frame);
	}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	
	
	private class Holder implements MouseListener, WindowStateListener, E
	{
		private TrayIcon tray;
		private JFrame frame;
		private int state;
		
		public Holder(TrayIcon tray, JFrame frame)
		{
			this.tray = tray;
			this.frame = frame;
			state = frame.getExtendedState();
			
			tray.addMouseListener(this);
			frame.addWindowStateListener(this);
		}
		
		public void e() throws Exception
		{changeActivation();}
	
	
	
		public void windowStateChanged(WindowEvent e)
		{
			if(e.getNewState()==1 || e.getNewState()==7)
			{
				frame.setVisible(false);
				state = e.getOldState();
			}
		}
	
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e)
		{
			if(e.getButton()==MouseEvent.BUTTON1)
				changeActivation();
		}

		private void changeActivation()
		{
			if(!frame.isVisible()) activate();
			else disactivate();
		}
		
		private void activate()
		{
			frame.setVisible(true);
			frame.setExtendedState(state);
			frame.toFront();
		}
		
		private void disactivate()
		{
			state = frame.getExtendedState();
			frame.setVisible(false);
		}
	}
}
