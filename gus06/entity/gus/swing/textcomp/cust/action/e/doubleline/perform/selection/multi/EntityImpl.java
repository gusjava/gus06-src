package gus06.entity.gus.swing.textcomp.cust.action.e.doubleline.perform.selection.multi;

import gus06.framework.*;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160426";}

	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		PlainDocument document = (PlainDocument) comp.getDocument();
		int length = document.getLength();
		
		Element element1 = document.getParagraphElement(comp.getSelectionStart());
		Element element2 = document.getParagraphElement(comp.getSelectionEnd());
		
		int start = element1.getStartOffset();
		int end = element2.getEndOffset();
		
		String text = document.getText(start,end-start);
		
		document.insertString(end,text,null);
	}
}
