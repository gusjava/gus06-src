package gus06.entity.gus.swing.label.build.filelabel;

import gus06.framework.*;
import java.util.Timer;
import java.io.File;
import java.util.Date;
import javax.swing.JLabel;
import java.util.TimerTask;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141209";}

	public static final long LAPSE = 500;


	private Service labelCust1;
	private Service labelCust2;
	
	private Timer timer;
	

	public EntityImpl() throws Exception
	{
		labelCust1 = Outside.service(this,"gus.swing.label.cust3.filedisplay");
		labelCust2 = Outside.service(this,"gus.swing.label.cust3.filedisplay2");
		
		timer = new Timer("TIMER_"+getClass().getName());
	}
	
	
	public Object t(Object obj) throws Exception
	{return new JLabel1((File) obj);}
	
	
	
	private void updateLabel(Service s, JLabel label, File file)
	{
		try{s.p(new Object[]{label,file});}
		catch(Exception e)
		{Outside.err(this,"updateLabel(JLabel,File)",e);}
	}

	
	
	
	private class JLabel1 extends JLabel implements P, G
	{
		private File file;
		private TimerTask task;
		
		public JLabel1(File file)
		{
			super(" ");
			this.file = file;
			updateLabel(labelCust1,this,file);
			
			task = new TimerTask() {public void run() {update_();}};
			timer.schedule(task,new Date(),LAPSE);
		}
		
		
		public synchronized Object g() throws Exception
		{return file;}
		
		
		public synchronized void p(Object obj) throws Exception
		{
			file = (File) obj;
			updateLabel(labelCust1,this,file);
		}
		
		
		private synchronized void update_()
		{updateLabel(labelCust2,this,file);}
	}
}
