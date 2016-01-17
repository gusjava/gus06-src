package gus06.entity.gus.swing.textcomp.cust.action.escap.focusback.perform;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151107";}


	private Service focusManager;
	
	public EntityImpl() throws Exception
	{
		focusManager = Outside.service(this,"gus.swing.textcomp.textfocus.manager");
	}
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		E holder = (E) focusManager.t(comp);
		holder.e();
	}
}
