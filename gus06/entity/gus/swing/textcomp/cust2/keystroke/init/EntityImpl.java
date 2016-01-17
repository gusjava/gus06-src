package gus06.entity.gus.swing.textcomp.cust2.keystroke.init;

import java.awt.Event;
import java.awt.event.KeyEvent;
import javax.swing.Action;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;
import gus06.framework.*;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20150622";}


	private Service toAction;

	public EntityImpl() throws Exception
	{toAction = Outside.service(this,"gus.find.action");}



	public void v(String key, Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		KeyStroke stroke = findKeyStroke(key);
		JTextComponent comp = (JTextComponent) o[0];
		Action action = toAction(o[1]);
		
		comp.getInputMap().put(stroke,action);
	}

	
	private KeyStroke findKeyStroke(String info) throws Exception
	{return KeyStroke.getKeyStroke(info);}
	
	private Action toAction(Object obj) throws Exception
	{return (Action) toAction.t(obj);}
}
