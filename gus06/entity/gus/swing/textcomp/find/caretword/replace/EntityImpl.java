package gus06.entity.gus.swing.textcomp.find.caretword.replace;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Vector;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20140915";}


	
	
	public void v(String key, Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		int[] range = findRange(comp);
		
		String text = comp.getText();
		String newText = text.substring(0,range[0]+1) + key + text.substring(range[1]);
		
		comp.setText(newText);
		comp.setCaretPosition(range[0]+1+key.length());
	}
	
	
	
	
	
	private int[] findRange(JTextComponent comp)
	{
		String s = comp.getSelectedText();
		if(s!=null && !s.equals(""))
		{
			return new int[]{
				comp.getSelectionStart(),
				comp.getSelectionEnd()
			};
		}
		
		int pos = comp.getCaretPosition();
		String text = comp.getText();
		int length = text.length();
		
		int start = pos-1;
    		int end = pos;
    	
    		while(start>=0 && !isWordDelim(text.charAt(start))) start--;	
    		while(end<length && !isWordDelim(text.charAt(end))) end++;
		
		return new int[]{start,end};
	}
	
	
	
	
	
	private boolean isWordDelim(char c)
	{return " ,;.?:.()[]/\\\t\n\r<>=-+'\"".contains(""+c);}
}
