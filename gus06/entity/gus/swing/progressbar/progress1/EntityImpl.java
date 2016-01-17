package gus06.entity.gus.swing.progressbar.progress1;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import java.awt.Color;

public class EntityImpl extends S1 implements Entity, I, R, V, E, F {

	public String creationDate() {return "20141026";}
	
	public final static Color COLOR_OVER = Color.GRAY;
	public final static Color COLOR_RUNNING = Color.LIGHT_GRAY;


	private JProgressBar bar;
	
	public EntityImpl() throws Exception
	{
		bar = new JProgressBar();
		bar.setBorderPainted(false);
		bar.setStringPainted(true);
		bar.setForeground(COLOR_RUNNING);
		bar.setMaximum(0);
	}
	
	
	public Object i() throws Exception
	{return bar;}
	
	

	public void e() throws Exception
	{increase();}


	public boolean f(Object obj) throws Exception
	{return value()<size() && value()>0;}
	
	

	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("size")){initSize((String)obj);return;}
		if(key.equals("reset")){reset();return;}
		if(key.equals("set")){set((String)obj);return;}
		if(key.equals("add")){add((String)obj);return;}
		if(key.equals("color")){initColor((Color)obj);return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("size")) return ""+size();
		if(key.equals("current")) return ""+value();
		
		if(key.equals("keys")) return new String[]{"size","current"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	
	private void initSize(String s)
	{
		bar.setMaximum(int_(s));
		reset();
	}
	
	
	private void reset()
	{setValue(0);}
	
	
	private void set(String s)
	{setValue(int_(s));}
	
	
	private void add(String s)
	{setValue(value()+int_(s));}
	
	
	private void increase()
	{setValue(value()+1);}
	
	
	
	private void initColor(Color color)
	{bar.setForeground(color);}
	
	
	
	private int int_(String s)
	{return Integer.parseInt(s);}
	
	
	private void setValue(int v)
	{
		int size = size();
		if(v>size) v = size;
		else if(v<0) v = 0;
		bar.setValue(v);
		
		if(v==0) bar.setForeground(COLOR_RUNNING);
		else if(v==bar.getMaximum())  bar.setForeground(COLOR_OVER);
		
		modified();
	}
	
	
	private int value()
	{return bar.getValue();}
	
	
	private int size()
	{return bar.getMaximum();}
	
	
	private void modified()
	{send(this,"modified()");}
}
