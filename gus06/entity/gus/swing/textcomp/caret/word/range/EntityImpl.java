package gus06.entity.gus.swing.textcomp.caret.word.range;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160505";}


	private Service getDelim;
	private String delim;

	public EntityImpl() throws Exception
	{
		getDelim = Outside.service(this,"gus.string.split.words1._delim");
		delim = (String) getDelim.g();
	}
	
	
	public Object t(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
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
	{return delim.indexOf(c)>=0;}
}
