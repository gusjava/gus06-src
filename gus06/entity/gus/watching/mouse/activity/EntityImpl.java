package gus06.entity.gus.watching.mouse.activity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import gus06.framework.*;

public class EntityImpl extends S1 implements Entity, F, ActionListener {

	public String creationDate() {return "20150626";}

	public static long WAIT = 30000;

	
	private Service watchMouse;
	
	private Timer timer;
	private TimerTask task;
	private boolean busy = false;
	


	public EntityImpl() throws Exception
	{
		watchMouse = Outside.service(this,"gus.watching.mouse");
		
		timer = new Timer("TIMER_"+getClass().getName());
		watchMouse.addActionListener(this);
	}
	
	
	
	public boolean f(Object obj) throws Exception
	{return busy;}
	
	
	
	public void actionPerformed(ActionEvent e)
	{busy();}
	
	
	
	
	private void busy()
	{
		if(!busy) in();
		busy = true;
		if(task!=null) task.cancel();	
		task = new TimerTask(){public void run(){sleeping();}};
		timer.schedule(task,WAIT);
	}
	
	
	
	
	private void sleeping()
	{
		if(busy) out();
		busy = false;
		task = null;
	}
	
	
	
	
	private void in()
	{send(this,"in()");}
	
	private void out()
	{send(this,"out()");}
}
