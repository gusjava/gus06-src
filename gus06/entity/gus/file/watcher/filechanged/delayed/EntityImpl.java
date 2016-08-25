package gus06.entity.gus.file.watcher.filechanged.delayed;

import java.util.Timer;
import java.util.TimerTask;

import gus06.framework.*;
import java.io.File;
import java.util.Date;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160527";}

	public static final long DELAY = 400;
	
	private Timer timer;
	
	public EntityImpl() throws Exception
	{
		timer = new Timer("TIMER_"+getClass().getName());
	}
	
	public Object t(Object obj) throws Exception
	{
		return new Holder((File) obj);
	}
	
	
	
	
	
	private class Holder extends S1 implements P, G
	{
		private File file;
		private TimerTask task;
		
		private boolean activated = true;
		private long m;
		
		public Holder(File file)
		{
			this.file = file;
			m = file.lastModified();
			
			task = new TimerTask(){public void run() {check();}};
			timer.schedule(task,new Date(),DELAY);
		}
		
		public Object g() throws Exception
		{return file;}
		
		public void p(Object obj) throws Exception
		{
			if(obj.equals("activate") && !activated)
			{activated = true;return;}
			
			if(obj.equals("disactivate") && activated)
			{activated = false;return;}
		}
		
		private void check()
		{
			if(!activated) return;
			long m0 = file.lastModified();
			if(m0 > m) fileChanged();
			m = m0;
		}
		
		private void fileChanged()
		{send(this,"fileChanged()");}
	}
}
