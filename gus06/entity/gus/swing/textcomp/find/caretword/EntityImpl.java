package gus06.entity.gus.swing.textcomp.find.caretword;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Vector;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140915";}


	
	
	public Object t(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		String s = comp.getSelectedText();
		if(s!=null && !s.equals("")) return s;
		
		String text = comp.getText();
		int length = text.length();
		int pos = comp.getCaretPosition();
		
		int start = pos-1;
    		int end = pos;
    	
    		while(start>=0 && !isWordDelim(text.charAt(start))) start--;	
    		while(end<length && !isWordDelim(text.charAt(end))) end++;

		return text.substring(start+1,end);
	}
	
	
	
	private boolean isWordDelim(char c)
	{return " ,;.?:.()[]/\\\t\n\r<>=-+'\"".contains(""+c);}
}
