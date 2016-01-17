package gus06.entity.gus.swing.textcomp.cust.action.left.gotohigh.previous.perform;

import gus06.framework.*;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140817";}

	
	
	public void p(Object obj) throws Exception
	{perform((JTextComponent) obj);}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
        	int p = comp.getCaretPosition();
        	
		Highlighter high = comp.getHighlighter();
        	Highlighter.Highlight[] h = high.getHighlights();
        	for(int i=h.length-1;i>=0;i--)
        	{
        		int start = h[i].getStartOffset();
        		int end = h[i].getEndOffset();
        		if(end<p)
        		{
        			comp.setSelectionStart(start);
        			comp.setSelectionEnd(end);
        			return;
        		}
        	}
        	comp.setCaretPosition(0);
	}
}
