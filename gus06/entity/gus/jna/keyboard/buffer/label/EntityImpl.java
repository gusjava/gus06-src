package gus06.entity.gus.jna.keyboard.buffer.label;

import gus06.framework.*;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Date;

public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20141218";}
	
	public static final long LAPSE = 100;


	private Service buffer;
	
	private Timer timer;
	private TimerTask task;
	
	private JLabel label;
	private ArrayList queue;


	public EntityImpl() throws Exception
	{
		buffer = Outside.service(this,"gus.jna.keyboard.buffer");
		
		label = new JLabel(" ");
		label.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		buffer.addActionListener(this);
		
		queue = new ArrayList();
		
		task = new TimerTask() {public void run() {consumNext();}};
		
		timer = new Timer("TIMER_"+getClass().getName());
		timer.schedule(task,new Date(),LAPSE);
	}
	
	
	public Object i() throws Exception
	{return label;}


	public void actionPerformed(ActionEvent e)
	{updateLabel();}
	
	
	
	
	private synchronized void updateLabel()
	{
		try{queue.add(getDisplay());}
		catch(Exception e)
		{Outside.err(this,"updateLabel()",e);}
	}
	
	private synchronized void consumNext()
	{
		if(queue.isEmpty()) return;
		String display = (String) queue.remove(0);
		label.setText(display);
	}
	
	
	
	
	
	private String getDisplay() throws Exception
	{
		String display = (String) buffer.g();
		if(display==null || display.equals("")) return " ";
		return display;
	}
}
