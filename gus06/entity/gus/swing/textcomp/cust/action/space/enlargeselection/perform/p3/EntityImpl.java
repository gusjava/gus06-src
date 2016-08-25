package gus06.entity.gus.swing.textcomp.cust.action.space.enlargeselection.perform.p3;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160426";}
	
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		comp.selectAll();
	}
}
