package gus06.entity.gus.swing.textcomp.cust.action.v.paste;

import gus06.framework.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Event;
import javax.swing.text.JTextComponent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160427";}

	public static final KeyStroke KEYSTROKE = KeyStroke.getKeyStroke(KeyEvent.VK_V,Event.CTRL_MASK);
	
	
	private Service perform;
	
	public EntityImpl() throws Exception
	{perform = Outside.service(this,"gus.swing.textcomp.cust.action.v.paste.perform");}
	
	
	public void p(Object obj) throws Exception
	{new Holder((JTextComponent) obj);}



	private class Holder extends AbstractAction
	{
		private JTextComponent comp;
		public Holder(JTextComponent comp)
		{
			this.comp = comp;
			comp.getInputMap().put(KEYSTROKE,this);
		}
		public void actionPerformed(ActionEvent e)
		{perform(comp);}
	}
	
	
	private void perform(JTextComponent comp)
	{
		try{perform.p(comp);}
		catch(Exception e)
		{Outside.err(this,"perform(JTextComponent)",e);}
	}
}
