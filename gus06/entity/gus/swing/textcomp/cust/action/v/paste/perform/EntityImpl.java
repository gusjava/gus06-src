package gus06.entity.gus.swing.textcomp.cust.action.v.paste.perform;

import gus06.framework.*;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160427";}


	private Service findPainter;
	private Service highlight;

	public EntityImpl() throws Exception
	{
		findPainter = Outside.service(this,"gus.swing.textcomp.highlight.painter.findatposition");
		highlight = Outside.service(this,"gus.swing.textcomp.cust.action.v.paste.perform.highlightpainter");
	}
	
	
	public void p(Object obj) throws Exception
	{
		perform((JTextComponent) obj);
	}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		if(hasSelection(comp))
		{comp.paste();return;}
		
		Object painter = findPainter.t(comp);
		if(painter!=null)
		{
			highlight.p(new Object[]{comp,painter});
			return;
		}
		
		comp.paste();
	}
	
	
	private boolean hasSelection(JTextComponent comp)
	{
		String s = comp.getSelectedText();
		return s!=null && !s.equals("");
	}
}
