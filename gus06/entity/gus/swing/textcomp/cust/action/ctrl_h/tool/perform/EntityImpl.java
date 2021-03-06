package gus06.entity.gus.swing.textcomp.cust.action.ctrl_h.tool.perform;

import gus06.framework.*;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141105";}


	private Service transformText;
	private Service chooseTrans;
	private Service findPainter;
	private Service highlight;


	public EntityImpl() throws Exception
	{
		transformText = Outside.service(this,"gus.swing.textcomp.perform3.transformtext");
		chooseTrans = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_h.tool.perform.chooser");
		findPainter = Outside.service(this,"gus.swing.textcomp.highlight.painter.findatposition");
		highlight = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_h.tool.perform.highlightpainter");
	}
	
	
	public void p(Object obj) throws Exception
	{perform((JTextComponent) obj);}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		T t = (T) chooseTrans.g();
		if(t==null) return;
		
		if(hasSelection(comp))
		{
			transformText.p(new Object[]{comp,t});
			return;
		}
		
		Object painter = findPainter.t(comp);
		if(painter!=null)
		{
			highlight.p(new Object[]{comp,painter,t});
			return;
		}
		
		transformText.p(new Object[]{comp,t});
	}
	
	
	
	
	private boolean hasSelection(JTextComponent comp)
	{
		String s = comp.getSelectedText();
		return s!=null && !s.equals("");
	}
}
