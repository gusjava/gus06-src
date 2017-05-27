package gus06.entity.gus.data.perform.schedule.each;

import gus06.framework.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160924";}


	private Service findTimerTask;
	private Timer timer;
	
	
	public EntityImpl() throws Exception
	{
		findTimerTask = Outside.service(this,"gus.find.timertask");
		timer = new Timer("TIMER_"+getClass().getName());
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		TimerTask task = (TimerTask) findTimerTask.t(o[0]);
		long t = toLong(o[1]);
		
		timer.scheduleAtFixedRate(task,new Date(),t);
	}
	
	
	private long toLong(Object obj)
	{return Long.parseLong(""+obj);}
}
