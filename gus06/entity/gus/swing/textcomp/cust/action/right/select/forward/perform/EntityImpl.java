package gus06.entity.gus.swing.textcomp.cust.action.right.select.forward.perform;

import gus06.framework.*;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160428";}

	
	
	public void p(Object obj) throws Exception
	{perform((JTextComponent) obj);}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		int pos = comp.getCaretPosition();
		String text = comp.getText();
		int length = text.length();
		
        	int start = pos;
        	int end = pos;
		
		while(end<length && !isLineDelim(text.charAt(end))) end++;
		
		int start0 = comp.getSelectionStart();
		int end0 = comp.getSelectionEnd();
		if(start==start0 && end==end0) end = length; 
		
		comp.getCaret().setDot(end);
		comp.getCaret().moveDot(start);
	}
	
	
	private boolean isLineDelim(char c)
	{return c=='\n' || c=='\r';}
}
