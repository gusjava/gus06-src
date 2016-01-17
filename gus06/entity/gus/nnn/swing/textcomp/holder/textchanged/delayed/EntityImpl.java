package gus06.entity.gus.nnn.swing.textcomp.holder.textchanged.delayed;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

import gus06.framework.*;


public class EntityImpl extends S1 implements Entity, P, G, DocumentListener {

	public String creationDate() {return "20140814";}


	public static final long DELAY = 400;
    
	private Timer timer;
	private JTextComponent comp;
	private TimerTask task;
	
    
	public EntityImpl() throws Exception
	{
		timer = new Timer("TIMER_"+getClass().getName());
	}
	
	
	public Object g() throws Exception
	{return comp;}
	
	
	public void p(Object obj) throws Exception
	{
		cancelTask();
		if(comp!=null) comp.getDocument().removeDocumentListener(this);
		comp = (JTextComponent) obj;
		if(comp!=null) comp.getDocument().addDocumentListener(this);
	}

	
	public void changedUpdate(DocumentEvent e) {}
	public void insertUpdate(DocumentEvent e) {textChanged_();}
	public void removeUpdate(DocumentEvent e) {textChanged_();}
        
        
        
        
	private void textChanged_()
	{
		cancelTask();
		task = new TimerTask0();
		timer.schedule(task,DELAY);
	}
    
    
    
	private class TimerTask0 extends TimerTask
	{
		public void run()
		{finishTask();}
	}

	
        

	private synchronized void finishTask()
	{
		task = null;
		changed();
	}
	
	
	private synchronized void cancelTask()
	{
		if(task==null) return;
		task.cancel();
		task = null;
	}
	
	private void changed()
	{send(this,"changed()");}
}
