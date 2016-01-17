package gus06.entity.gus.sys.webserver1.web2.session;

import gus06.framework.*;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.io.PrintStream;

public class EntityImpl implements Entity, R {

	public String creationDate() {return "20140930";}
	
	
	public static final long CHECKTIME = 20000; // 20 SEC
	public static final long EXPIRETIME = 300000; // 5 MIN

	public static final String KEY_DATESTART = "date_start";
	public static final String KEY_DATELAST = "date_last";
	public static final String KEY_ADDRESS = "address";
	public static final String KEY_TIMES = "times";
	public static final String KEY_ACCESS = "access";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	private String sdf(Date d) {return sdf.format(d);}


	private Service accessBuilder;
	private PrintStream out;
	
	private Map map;
	private Timer timer;
	
	
	
	
	public EntityImpl() throws Exception
	{
		accessBuilder = Outside.service(this,"gus.sys.webserver1.web2.session.access");
		out = (PrintStream) Outside.resource(this,"sysout");
		
		map = new HashMap();
		timer = new Timer("TIMER_"+getClass().getName());
		
		TimerTask task = new TimerTask() {public void run() {check();}};
		timer.schedule(task,new Date(),CHECKTIME);
	}
	
	
	public Object r(String key) throws Exception
	{
		Map session = null;
		synchronized(map)
		{
			if(!map.containsKey(key))
			session = startSession(key);
			else session = updateSession(key);
		}
		return session;
	}
	
	
	
	
	private Map startSession(String address) throws Exception
	{
		Date date = new Date();
		Map session = new HashMap();
		session.put(KEY_DATESTART,date);
		session.put(KEY_DATELAST,date);
		session.put(KEY_TIMES,new Integer(1));
		session.put(KEY_ADDRESS,address);
		session.put(KEY_ACCESS,buildAccess(address));
		map.put(address,session);
		
		out.println(sdf(date)+": Session started: "+address);
		return session;
	}
	
	
	
	private Map updateSession(String address)
	{
		Map session = (Map) map.get(address);
		Integer times = (Integer) session.get(KEY_TIMES);
		session.put(KEY_DATELAST,new Date());
		session.put(KEY_TIMES,new Integer(times.intValue()+1));
		
		return session;
	}
	
	
	
	
	
	
	
	private void check()
	{
		synchronized(map)
		{
			Iterator it = map.keySet().iterator();
			while(it.hasNext())
			{
				String key = (String) it.next();
				Map session = (Map) map.get(key);
				if(isExpired(session))
				{
					removeAccess_(key);
					it.remove();
					out.println("Session cleared: "+key);
				}
			}
		}
	}
	
	
	
	
	
	
	private boolean isExpired(Map session)
	{
		if(!session.containsKey(KEY_DATELAST)) return true;
		Date last = (Date) session.get(KEY_DATELAST);
		long sessionTime = last.getTime();
		
		return System.currentTimeMillis()-sessionTime > EXPIRETIME;
	}
	
	
	
	
	
	
	private Object buildAccess(String address) throws Exception
	{return accessBuilder.r(address);}
	
	private void removeAccess(String address) throws Exception
	{accessBuilder.p(address);}
	
	
	
	private void removeAccess_(String address)
	{
		try{removeAccess(address);}
		catch(Exception e)
		{Outside.err(this,"removeAccess_(String)",e);}
	}
}
