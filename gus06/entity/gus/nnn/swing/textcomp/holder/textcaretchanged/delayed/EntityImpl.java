package gus06.entity.gus.nnn.swing.textcomp.holder.textcaretchanged.delayed;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.JTextComponent;

import gus06.framework.*;


public class EntityImpl extends S1 implements Entity, P, G, DocumentListener, CaretListener {

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
		if(comp!=null)
		{
			comp.getDocument().removeDocumentListener(this);
			comp.removeCaretListener(this);
		}
		comp = (JTextComponent) obj;
		if(comp!=null)
		{
			comp.getDocument().addDocumentListener(this);
			comp.addCaretListener(this);
		}
	}

	
	public void changedUpdate(DocumentEvent e) {}
	public void insertUpdate(DocumentEvent e) {changed_();}
	public void removeUpdate(DocumentEvent e) {changed_();}
         public void caretUpdate(CaretEvent e) {changed_();}
        
        
        
        
	private void changed_()
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
