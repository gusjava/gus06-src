package gus06.entity.gus.swing.textcomp.cust.action.r.keepline.perform.caret.keepword;

import gus06.framework.*;
import javax.swing.text.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151105";}

	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		int pos = comp.getCaretPosition();
		String text = comp.getText();
		int length = text.length();
		
		int start = pos-1;
		int end = pos;
		
		while(start>=0 && !isWordDelim(text.charAt(start))) start--;	
		while(end<length && !isWordDelim(text.charAt(end))) end++;
		start++;
		
		comp.setText(text.substring(start,end));
		comp.setCaretPosition(pos-start);
	}
	
	private boolean isWordDelim(char c)
	{return " ,;:.!?{}()[]/\\\t\n\r<>=-+'\"".contains(""+c);}
}
