package gus06.entity.gus.swing.textcomp.cust.action.w_shift.smartreplace;

import gus06.framework.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Event;
import javax.swing.text.JTextComponent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160430";}

	public static final KeyStroke KEYSTROKE = KeyStroke.getKeyStroke(KeyEvent.VK_W,Event.CTRL_MASK + KeyEvent.SHIFT_MASK);
	
	
	private Service buildHolder;
	private Service buildTransform;
	
	public EntityImpl() throws Exception
	{
		buildHolder = Outside.service(this,"gus.sys.quickreplace.holder.find");
		buildTransform = Outside.service(this,"gus.swing.textcomp.cust.action.w_shift.smartreplace.t");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		P holder = (P) buildHolder.t(comp);
		new Holder(comp,holder);
	}



	private class Holder extends AbstractAction
	{
		private P holder;
		
		public Holder(JTextComponent comp, P holder)
		{
			this.holder = holder;
			comp.getInputMap().put(KEYSTROKE,this);
		}
		public void actionPerformed(ActionEvent e)
		{execute(holder);}
	}
	
	
	private void execute(P holder)
	{
		try{holder.p(buildTransform);}
		catch(Exception e)
		{Outside.err(this,"execute(P)",e);}
	}
}
