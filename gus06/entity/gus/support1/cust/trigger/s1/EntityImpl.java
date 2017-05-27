package gus06.entity.gus.support1.cust.trigger.s1;

import gus06.framework.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160909";}

	public static final long LAPSE = 1000;
	public static final String EVENT = "perform()";

	private Timer timer;
	
	public EntityImpl() throws Exception
	{
		timer = new Timer("TIMER_"+getClass().getName());
	}
	
	
	public void p(Object obj) throws Exception
	{
		Holder task = new Holder((S1) obj);
		timer.scheduleAtFixedRate(task,new Date(),LAPSE);
	}
	
	
	private class Holder extends TimerTask
	{
		private S1 s1;
		public Holder(S1 s1)
		{this.s1 = s1;}
		
		public void run()
		{s1.send(this,EVENT);}
	}
}