package gus06.entity.gus.swing.textcomp.textchanged.delayed;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140723";}


	public static final long DELAY = 400;
    
	private Timer timer;
    
	public EntityImpl() throws Exception
	{
		timer = new Timer("TIMER_"+getClass().getName());
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return new TextCompHolder((JTextComponent) obj);
	}
	
	
	
	
	
	private class TextCompHolder extends S1 implements DocumentListener, P, G
	{
		private JTextComponent comp;
		private TimerTask task;
		private boolean activated = true;
		
		public TextCompHolder(JTextComponent comp)
		{
		    this.comp = comp;
		    comp.getDocument().addDocumentListener(this);
		}
		
		public void changedUpdate(DocumentEvent e) {}
		public void insertUpdate(DocumentEvent e) {textChanged_();}
		public void removeUpdate(DocumentEvent e) {textChanged_();}
		
		private void textChanged_()
		{
		    if(task!=null) task.cancel();
		    task = new TimerTask0(this);
		    timer.schedule(task,DELAY);
		}
		
		public Object g() throws Exception
		{return comp;}
		

		public void p(Object obj) throws Exception
		{
			if(obj.equals("activate") && !activated)
			{
				activated = true;
				comp.getDocument().addDocumentListener(this);
			}
			else if(obj.equals("disactivate") && activated)
			{
				activated = false;
				comp.getDocument().removeDocumentListener(this);
			}
		}
    }
    
    
    
    
    
    
    
    private class TimerTask0 extends TimerTask
    {
		private S1 d;
		public TimerTask0(S1 d) {this.d = d;}
		public void run() {textChanged();}
		
		private void textChanged()
		{d.send(this,"textChanged()");}
    }
}
