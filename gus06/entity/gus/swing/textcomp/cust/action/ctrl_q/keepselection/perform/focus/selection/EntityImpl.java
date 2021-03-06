package gus06.entity.gus.swing.textcomp.cust.action.ctrl_q.keepselection.perform.focus.selection;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151107";}
	
	
	private Service handleRange;

	public EntityImpl() throws Exception
	{
		handleRange = Outside.service(this,"gus.swing.textcomp.textfocus.handlerange");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		int start = comp.getSelectionStart();
		int end = comp.getSelectionEnd();
		
		int[] range = new int[]{start,end};
		handleRange.p(new Object[]{comp,range});
	}
}
