package gus06.entity.gus.swing.textcomp.cust.action.b.execute.perform;

import gus06.framework.*;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150527";}


	private Service perform2;

	public EntityImpl() throws Exception
	{
		perform2 = Outside.service(this,"gus.swing.textcomp.cust.action.b.execute.perform2");
	}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof JTextArea)
		{
			JTextArea comp = (JTextArea) obj;
			String text = findText(comp);
			String[] lines = text.split("\n");
			for(String line:lines) perform2(comp,line);
		}
	}
	
	
	
	private String findText(JTextArea comp) throws Exception
	{
		PlainDocument document = (PlainDocument) comp.getDocument();
		if(hasSelection(comp)) return comp.getSelectedText();
		
		int p = comp.getCaretPosition();
		Element element = document.getParagraphElement(p);
		int start = element.getStartOffset();
		int end = element.getEndOffset();
		
		return document.getText(start,end-start);
	}
	
	
	
	private boolean hasSelection(JTextArea comp)
	{
		String s = comp.getSelectedText();
		return s!=null && !s.equals("");
	}
	
	
    
	private void perform2(JTextArea comp, String line) throws Exception
	{perform2.p(new Object[]{comp,line});}
}
