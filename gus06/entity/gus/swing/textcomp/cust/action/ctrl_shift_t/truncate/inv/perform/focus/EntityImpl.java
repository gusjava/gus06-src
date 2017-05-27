package gus06.entity.gus.swing.textcomp.cust.action.ctrl_shift_t.truncate.inv.perform.focus;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160827";}
	
	
	private Service handleRange;

	public EntityImpl() throws Exception
	{
		handleRange = Outside.service(this,"gus.swing.textcomp.textfocus.handlerange");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		PlainDocument document = (PlainDocument) comp.getDocument();
		
		int start = comp.getCaretPosition();
		int end = document.getLength();
		
		int[] range = new int[]{start,end};
		handleRange.p(new Object[]{comp,range});
	}
}
