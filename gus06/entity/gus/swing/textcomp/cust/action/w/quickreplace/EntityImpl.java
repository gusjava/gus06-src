package gus06.entity.gus.swing.textcomp.cust.action.w.quickreplace;

import gus06.framework.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Event;
import javax.swing.text.JTextComponent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140816";}

	public static final KeyStroke KEYSTROKE = KeyStroke.getKeyStroke(KeyEvent.VK_W,Event.CTRL_MASK);
	
	
	private Service buildExecute;
	
	public EntityImpl() throws Exception
	{buildExecute = Outside.service(this,"gus.swing.textcomp.cust.action.w.quickreplace.buildexecute");}
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		E execute = (E) buildExecute.t(comp);
		new Holder(comp,execute);
	}



	private class Holder extends AbstractAction
	{
		private E execute;
		
		public Holder(JTextComponent comp, E execute)
		{
			this.execute = execute;
			comp.getInputMap().put(KEYSTROKE,this);
		}
		public void actionPerformed(ActionEvent e)
		{execute(execute);}
	}
	
	
	private void execute(E execute)
	{
		try{execute.e();}
		catch(Exception e)
		{Outside.err(this,"execute(E)",e);}
	}
}
