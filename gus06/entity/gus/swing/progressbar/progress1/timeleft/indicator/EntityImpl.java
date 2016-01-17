package gus06.entity.gus.swing.progressbar.progress1.timeleft.indicator;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntityImpl implements Entity, ActionListener, P, R, E {

	public String creationDate() {return "20150919";}


	private Service formatDuration;
	private Service formatTime;


	private Object progress;
	
	private long start = -1;
	private long end = -1;
	private long total = -1;
	private long done = -1;
	private long left = -1;
	
	private double factor = -1;
	private boolean over = false;
	
	
	


	public EntityImpl() throws Exception
	{
		formatDuration = Outside.service(this,"gus.string.transform.format.duration.fr");
		formatTime = Outside.service(this,"gus.string.transform.format.timestamp.fr3");
	}
	
	
	
	public void e() throws Exception
	{
		over = true;
		
		end = now();
		total = end-start;
		left = 0;
		done = total;
	}
	
	
	
	public Object r(String key) throws Exception
	{
		updateValues();
		
		if(key.equals("start")) return ""+start;
		if(key.equals("end")) return ""+end;
		if(key.equals("total")) return ""+total;
		if(key.equals("done")) return ""+done;
		if(key.equals("left")) return ""+left;
		
		if(key.equals("display_start")) return formatTime(start);
		if(key.equals("display_end")) return formatTime(end);
		if(key.equals("display_total")) return formatDuration(total);
		if(key.equals("display_done")) return formatDuration(done);
		if(key.equals("display_left")) return formatDuration(left);
		
		if(key.equals("keys")) return new String[]{
			"start","end","total","done","left",
			"display_start","display_end","display_total","display_done","display_left"
		};
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		if(progress!=null) throw new Exception("Progress already initialized");
		progress = obj;
		((S) progress).addActionListener(this);
	}


	public void actionPerformed(ActionEvent e)
	{updateFactor();}
	
	
	private void updateFactor()
	{
		try{factor = computeFactor();}
		catch(Exception e)
		{Outside.err(this,"updateFactor()",e);}
	}
	
	
	
	private double computeFactor() throws Exception
	{
		if(over) throw new Exception("Progress have been cancel and is still running");
		
		int v = current();
		if(v==0)
		{
			over = false;
			start = now();
			return -1;
		}
		long done = now() - start;
		return (double)done/(double)v;	
	}
	
	
	
	private void updateValues() throws Exception
	{
		if(over) return;
		
		if(factor==-1)
		{
			end = -1;
			total = -1;
			done = -1;
			left = -1;
		}
		else
		{
			int v = current();
			int size = size();
			
			total = (long) (factor*size);
			done = now() - start;
			left = total - done;
			end = start + total;
		}
	}
	
	
	
	
	
	
	
	
	private String formatDuration(long v) throws Exception
	{
		if(v==-1) return "?";
		return (String) formatDuration.t(""+v);
	}
	
	private String formatTime(long v) throws Exception
	{
		if(v==-1) return "?";
		return (String) formatTime.t(""+v);
	}
	
	private int current() throws Exception
	{
		String s = (String) ((R)progress).r("current");
		return Integer.parseInt(s);
	}
	
	private int size() throws Exception
	{
		String s = (String) ((R)progress).r("size");
		return Integer.parseInt(s);
	}
	
	private long now()
	{return System.currentTimeMillis();}
}
