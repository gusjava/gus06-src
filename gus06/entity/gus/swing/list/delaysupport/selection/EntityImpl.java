package gus06.entity.gus.swing.list.delaysupport.selection;

import java.util.Timer;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import gus06.framework.*;
import java.util.TimerTask;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150613";}

	private long delay = 400;
	private Timer timer;
	
	
	public EntityImpl()
	{timer = new Timer("TIMER_"+getClass().getName());}
	

	public Object t(Object obj) throws Exception
	{return new DelaySupport(delay,(JList)obj);}

	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("delay"))
		{delay = Long.parseLong((String)obj);return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	
	private class DelaySupport extends S1 implements ListSelectionListener
	{
		private long delay;
		private TimerTask task;
		
		public DelaySupport(long delay, JList list)
		{
			this.delay = delay;
			list.getSelectionModel().addListSelectionListener(this);
		}
	
		public void valueChanged(ListSelectionEvent e)
		{
			if(task!=null) task.cancel();
			task = new TimerTask(){public void run() {selectionChanged();}};
			timer.schedule(task,delay);
		}
		
		private void selectionChanged()
		{send(this,"selectionChanged()");}
	}
}
