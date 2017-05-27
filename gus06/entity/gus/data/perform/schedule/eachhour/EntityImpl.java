package gus06.entity.gus.data.perform.schedule.eachhour;

import gus06.framework.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160924";}

	public static final long LAPSE = 3600000;


	private Service findTimerTask;
	private Timer timer;
	
	
	public EntityImpl() throws Exception
	{
		findTimerTask = Outside.service(this,"gus.find.timertask");
		timer = new Timer("TIMER_"+getClass().getName());
	}
	
	
	public void p(Object obj) throws Exception
	{
		TimerTask task = (TimerTask) findTimerTask.t(obj);
		timer.scheduleAtFixedRate(task,new Date(),LAPSE);
	}
}
