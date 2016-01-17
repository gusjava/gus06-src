package gus06.entity.gus.watching.online;

import gus06.framework.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class EntityImpl extends S1 implements Entity, F, R {

	public String creationDate() {return "20141006";}


	public static final String URLTEST = "http://www.google.com";
	public static final long PERIOD = 4000;
	
	
	
	private URL urlTest;
	private boolean isOnline = false;
	private Exception e;

	private Timer timer;
	private TimerTask task;
	

	
	public EntityImpl() throws Exception
	{
		urlTest = new URL(URLTEST);
		testConnection();
		
		task = new TimerTask(){public void run()
		{testConnection();}};
		
		timer = new Timer("TIMER_"+getClass().getName());
		timer.schedule(task,new Date(),PERIOD);
	}
	
	
	
	
	private void testConnection()
	{
		try
		{
			urlTest.openConnection().connect();
			this.e = null;
			if(isOnline) return;
			
			isOnline = true;
			online();
		}
		catch(IOException e)
		{
			this.e = e;
			if(!isOnline) return;
			
			isOnline = false;
			offline();
		}
	}
	
	
	
	private void online()
	{send(this,"online()");}
	
	private void offline()
	{send(this,"offline()");}



	public boolean f(Object obj) throws Exception
	{return isOnline;}
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("exception")) return e;
		if(key.equals("keys")) return new String[]{"exception"};
		throw new Exception("Unknown key: "+key);
	}
}
