package gus06.entity.gus.awt.window.autopack;

import gus06.framework.*;
import java.awt.Window;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20161127";}

	public static final long LAPSE = 100;
	

	private Timer timer;

	public EntityImpl() throws Exception
	{
		timer = new Timer("TIMER_"+getClass().getName());
	}
	
	
	public void p(Object obj) throws Exception
	{
		PackTask task = new PackTask((Window) obj);
		timer.schedule(task,new Date(),LAPSE);
	}
	
	
	private class PackTask extends TimerTask
	{
		private Window w;
		
		public PackTask(Window w)
		{this.w = w;}
		
		public void run()
		{w.pack();}
	}
}
