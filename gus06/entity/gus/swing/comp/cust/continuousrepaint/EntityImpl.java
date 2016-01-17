package gus06.entity.gus.swing.comp.cust.continuousrepaint;

import gus06.framework.*;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Iterator;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150604";}
	
	public static final long LAPSE = 100;
	
	
	private Timer timer;
	private TimerTask task;
	
	private Set set;
	
	
	
	public EntityImpl() throws Exception
	{
		set = new HashSet();
	
		task = new TimerTask() {public void run() {check();}};
		timer = new Timer("TIMER_"+getClass().getName());
		timer.schedule(task,new Date(),LAPSE);
	}



	public synchronized void p(Object obj) throws Exception
	{set.add((Component) obj);}
	
	
	
	private synchronized void check()
	{
		Iterator it = set.iterator();
		while(it.hasNext())
		{
			Component c = (Component) it.next();
			c.repaint();
		}
	}
}
