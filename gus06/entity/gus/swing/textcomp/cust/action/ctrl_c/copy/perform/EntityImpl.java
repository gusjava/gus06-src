package gus06.entity.gus.swing.textcomp.cust.action.ctrl_c.copy.perform;

import gus06.framework.*;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160425";}


	private Service selectP0;
	private Service findPainter;
	private Service highlight;

	public EntityImpl() throws Exception
	{
		selectP0 = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_space.enlargeselection.perform.p0");
		findPainter = Outside.service(this,"gus.swing.textcomp.highlight.painter.findatposition");
		highlight = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_c.copy.perform.highlightpainter");
	}
	
	
	public void p(Object obj) throws Exception
	{
		perform((JTextComponent) obj);
	}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		if(hasSelection(comp))
		{comp.copy();return;}
		
		Object painter = findPainter.t(comp);
		if(painter!=null)
		{
			highlight.p(new Object[]{comp,painter});
			return;
		}
		
		selectP0.p(comp);
		comp.copy();
	}
	
	
	private boolean hasSelection(JTextComponent comp)
	{
		String s = comp.getSelectedText();
		return s!=null && !s.equals("");
	}
}
