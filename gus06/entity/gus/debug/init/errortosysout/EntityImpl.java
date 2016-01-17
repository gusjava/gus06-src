package gus06.entity.gus.debug.init.errortosysout;

import gus06.framework.*;

import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class EntityImpl implements Entity, ActionListener, Runnable {

	public String creationDate() {return "20140913";}

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	private String now() {return sdf.format(new Date());}
	
	
	private List errors;
	private List pending;
	private Thread t;
	
	private PrintStream out;


	public EntityImpl() throws Exception
	{
		errors = (List) Outside.resource(this,"errors");
		out = (PrintStream) Outside.resource(this,"sysout");
		pending = new ArrayList();
		
		t = new Thread(this,"THREAD_"+getClass().getName());
		t.start();
		
		((S) errors).addActionListener(this);
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{enqueueLastErr();}
	
	
	
	public void enqueueLastErr()
	{
		try
		{
			Object[] o = (Object[]) errors.get(errors.size()-1);
			if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
			synchronized(pending) {pending.add(o);}
		}
		catch(Exception e)
		{Outside.err(this,"enqueueLastErr()",e);}
	}
	
	
	
	
	public void run()
	{
		while(true)
		{perform();sleep1();}
	}
	
	
	
	private void sleep1()
	{
		try{Thread.sleep(1);}
		catch(Exception e){Outside.err(this,"sleep1()",e);}
	}
		
	
	
	private void perform()
	{
		Object[] o = null;
		synchronized(pending)
		{o = retrieveErr();}
		if(o!=null) printErr(o);
	}
	
	
	
	private Object[] retrieveErr()
	{
		if(pending.isEmpty()) return null;
		return (Object[]) pending.remove(0);
	}
	
	
	
	private void printErr(Object[] o)
	{
		try
		{
			Entity entity = (Entity) o[0];
			String id = (String) o[1];
			Exception exp = (Exception) o[2];
			Date date = (Date) o[3];
	
			String src = entity.getClass().getName()+"@"+id;
			String timeStamp = sdf.format(date);
		
			println("___________________");
			println("time:"+timeStamp);
			println("src:"+src);
			println("");
			exp.printStackTrace(out);
		}
		catch(Exception e)
		{Outside.err(this,"printErr(Object[])",e);}
	}
	
	
	private void println(String m)
	{out.println(m);}
}
