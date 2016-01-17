package gus06.entity.gus.swing.textcomp.cust.action.e.doubleline.perform;

import gus06.framework.*;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140816";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof JTextArea)
		perform((JTextComponent) obj);
	}
	
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		PlainDocument document = (PlainDocument) comp.getDocument();
		if(hasSelection(comp))
		{
			int start = comp.getSelectionStart();
			int end = comp.getSelectionEnd();
			doubleElements(document,start,end);
		}
		else
		{
			int p = comp.getCaretPosition();
			doubleElement(document,p);
		}
	}
	
	
	
	private boolean hasSelection(JTextComponent comp)
	{
		String s = comp.getSelectedText();
		return s!=null && !s.equals("");
	}
    
    
	private void doubleElement(PlainDocument document, int p) throws Exception
	{
		Element element = document.getParagraphElement(p);
		doubleElement(document,element);
	}
	
    
	private void doubleElement(PlainDocument document, Element element) throws Exception
	{
		int start = element.getStartOffset();
		int end = element.getEndOffset();
		String text = document.getText(start,end-start);
		if(!text.equals("")) document.insertString(end,text,null);
	}
    
    
    
	private void doubleElements(PlainDocument document, int start, int end) throws Exception
	{
		Element element1 = document.getParagraphElement(start);
		Element element2 = document.getParagraphElement(end);
		doubleElements(document,element1,element2);
	}
    

	private void doubleElements(PlainDocument document, Element element1, Element element2) throws Exception
	{
		int start = element1.getStartOffset();
		int end = element2.getEndOffset();
		String text = document.getText(start,end-start);
		if(!text.equals("")) document.insertString(end,text,null);
	}
}
