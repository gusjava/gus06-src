package gus06.entity.gus.swing.textcomp.cust.action.q.keepselection.perform.caret;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151105";}


	private Service highlight;
	private Service findPainter;

	public EntityImpl() throws Exception
	{
		highlight = Outside.service(this,"gus.swing.textcomp.cust.action.q.keepselection.perform.caret.painter");
		findPainter = Outside.service(this,"gus.swing.textcomp.highlight.painter.findatposition");
	}

	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		Object painter = findPainter.t(comp);
		if(painter!=null) highlight.p(new Object[]{comp,painter});
		else comp.setText("");
	}
}
