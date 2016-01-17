package gus06.entity.gus.swing.textcomp.cust.autoedit.javaediting1.perform;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140816";}


	private Service perform_enter;
	private Service perform_tab;

	public EntityImpl() throws Exception
	{
		perform_enter = Outside.service(this,"gus.swing.textcomp.cust.autoedit.javaediting1.perform.enter");
		perform_tab = Outside.service(this,"gus.swing.textcomp.cust.autoedit.javaediting1.perform.tab");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		JTextComponent comp = (JTextComponent) o[0];
		KeyEvent evt = (KeyEvent) o[1];
		
		int code = evt.getKeyCode();
		
		switch(code)
		{
			case KeyEvent.VK_ENTER: perform_enter.p(comp);break;
			case KeyEvent.VK_TAB: perform_tab.p(comp);break;
		}
	}
}
