package gus06.entity.gus.sys.filetool.ext.dbviewer1.holder;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, I, P, Runnable {

	public String creationDate() {return "20161114";}

	public static final String URL = "url";
	public static final String USER = "user";
	public static final String PWD = "pwd";
	

	private Service gui;
	private Service builder;
	
	private Map map;
	private Thread t;
	


	public EntityImpl() throws Exception
	{
		gui = Outside.service(this,"*gus.jdbc.gui.cx1");
		builder = Outside.service(this,"gus.jdbc.connection.holder");
	}
	
	
	public Object i() throws Exception
	{return gui.i();}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		if(t!=null && t.isAlive()) return;
		
		map = (Map) obj;
		
		t = new Thread(this,"THREAD_"+getClass().getName());
		t.start();
	}
	
	
	
	public void run()
	{
		try
		{
			String url = get0(URL);
			String user = get0(USER);
			String pwd = get0(PWD);
		
			if(url==null) return;
			if(user==null) return;
			if(pwd==null) return;
			
			Object cxHolder = builder.t(new String[]{url,user,pwd});
			gui.p(cxHolder);
		}
		catch(Exception e)
		{Outside.err(this,"run()",e);}
	}
	
	
	
	private String get0(String key) throws Exception
	{
		if(map==null) throw new Exception("Map not initialized yet");
		if(!map.containsKey(key)) return null;
		return (String) map.get(key);
	}
}
