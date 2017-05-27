package gus06.entity.gus.data.perform.schedule.at;

import gus06.framework.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160924";}


	private Service findDate;
	private Service findTimerTask;

	private Timer timer;
	
	
	public EntityImpl() throws Exception
	{
		findDate = Outside.service(this,"gus.find.date");
		findTimerTask = Outside.service(this,"gus.find.timertask");
		
		timer = new Timer("TIMER_"+getClass().getName());
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object execute = o[0];
		Object data = o[1];
		
		if(data instanceof List)
		{
			List list = (List) data;
			for(Object element:list) schedule(execute,element);
			return;
		}
		
		if(data instanceof Set)
		{
			Set set = (Set) data;
			for(Object element:set) schedule(execute,element);
			return;
		}
		
		if(data instanceof Date[])
		{
			Date[] dates = (Date[]) data;
			for(Date date:dates) schedule(execute,date);
			return;
		}
		
		schedule(execute,data);
	}
	
	
	private void schedule(Object execute, Object data) throws Exception
	{
		TimerTask task = (TimerTask) findTimerTask.t(execute);
		Date date = (Date) findDate.t(data);
		
		timer.schedule(task,date);
	}
}
