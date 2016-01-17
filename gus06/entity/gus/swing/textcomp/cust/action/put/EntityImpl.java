package gus06.entity.gus.swing.textcomp.cust.action.put;

import gus06.framework.*;

import java.awt.Event;
import java.awt.event.KeyEvent;
import javax.swing.Action;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140727";}

	private Service findKeystroke;

	public EntityImpl() throws Exception
	{
		findKeystroke = Outside.service(this,"gus.find.keystroke");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);

		JTextComponent comp = (JTextComponent) o[0];
		Action action = (Action) o[1];
		KeyStroke key = (KeyStroke) findKeystroke.t(o[2]);

		comp.getInputMap().put(key,action);
	}
}
