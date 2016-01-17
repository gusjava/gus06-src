package gus06.entity.gus.swing.dialog.build.dialogontop;

import gus06.framework.*;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

public class EntityImpl implements Entity, T, P {

	public String creationDate() {return "20140915";}

	private Timer timer;

	public EntityImpl() throws Exception
	{
		timer = new Timer("TIMER_"+getClass().getName());
	}
	
	
	public void p(Object obj) throws Exception
	{
    		Dialog1 d = new Dialog1((JComponent) obj);
		d.setVisible(true);
	}
	
	
	public Object t(Object obj) throws Exception
	{
    		Dialog1 d = new Dialog1((JComponent) obj);
    		d.setVisible(true);
		return d;
	}
	
	
	
	
	
	private class Dialog1 extends JDialog
	{
		public Dialog1(JComponent content)
		{
			super((JFrame)null,false);
			
			setUndecorated(true);
			setResizable(false);
			setAlwaysOnTop(true);
			
			setContentPane(content);
			setLocationRelativeTo(null);
			
			TimerTask task = new TimerTask(){public void run(){updateGui();}};
	    		timer.schedule(task,new Date(),100);
		}
		
		private void updateGui()
		{
			pack();
		}
	}
}
