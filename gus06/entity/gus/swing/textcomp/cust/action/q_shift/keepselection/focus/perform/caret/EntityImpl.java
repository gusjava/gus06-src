package gus06.entity.gus.swing.textcomp.cust.action.q_shift.keepselection.focus.perform.caret;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151107";}


	private Service highlight;
	private Service findPainter;
	private Service handleRange;

	public EntityImpl() throws Exception
	{
		highlight = Outside.service(this,"gus.swing.textcomp.cust.action.q_shift.keepselection.focus.perform.caret.painter");
		findPainter = Outside.service(this,"gus.swing.textcomp.highlight.painter.findatposition");
		handleRange = Outside.service(this,"gus.swing.textcomp.textfocus.handlerange");
	}

	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		Object painter = findPainter.t(comp);
		if(painter!=null)
		{
			highlight.p(new Object[]{comp,painter});
			return;
		}
		
		int pos = comp.getCaretPosition();
		int[] range = new int[]{pos,pos};
		handleRange.p(new Object[]{comp,range});
	}
}
