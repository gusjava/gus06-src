package gus06.entity.gus.time.timer.ms10;

import gus06.framework.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EntityImpl extends S1 implements Entity {

	public String creationDate() {return "20161006";}

	public static final long LAPSE = 10;
	

	private Timer timer;
	
	public EntityImpl() throws Exception
	{
		TimerTask task = new TimerTask(){
			public void run() {perform();}
		};
		
		timer = new Timer("TIMER_"+getClass().getName());
		timer.scheduleAtFixedRate(task,new Date(),LAPSE);
	}

	
	private void perform()
	{send(this,"perform()");}
}