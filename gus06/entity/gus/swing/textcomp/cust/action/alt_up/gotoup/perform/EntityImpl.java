package gus06.entity.gus.swing.textcomp.cust.action.alt_up.gotoup.perform;

import gus06.framework.*;
import javax.swing.text.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160512";}
	
	public static final int GAP = 10;

	
	
	public void p(Object obj) throws Exception
	{perform((JTextComponent) obj);}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		PlainDocument document = (PlainDocument) comp.getDocument();
		Element root = document.getDefaultRootElement();
		
		int p = comp.getCaretPosition();
		Element element0 = document.getParagraphElement(p);
		int d0 = p-element0.getStartOffset();
		
		int index = root.getElementIndex(p) - GAP;
		if(index<0) index = 0;
		
		Element element1 = root.getElement(index);
		int d1 = element1.getEndOffset() - element1.getStartOffset();
		int p1 = element1.getStartOffset() + Math.min(d0,d1);
		
		comp.setCaretPosition(p1);
	}
}
