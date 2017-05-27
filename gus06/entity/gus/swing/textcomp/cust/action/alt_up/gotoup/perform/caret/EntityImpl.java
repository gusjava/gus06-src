package gus06.entity.gus.swing.textcomp.cust.action.alt_up.gotoup.perform.caret;

import gus06.framework.*;
import javax.swing.text.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160904";}

	
	
	public void p(Object obj) throws Exception
	{perform((JTextComponent) obj);}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		int p = comp.getCaretPosition();
		
		Highlighter high = comp.getHighlighter();
		Highlighter.Highlight[] h = high.getHighlights();
		for(int i=0;i<h.length;i++)
		{
			int start = h[i].getStartOffset();
			int end = h[i].getEndOffset();
			if(start>=p) break;
			
			if(start!=end)
			{
				comp.setCaretPosition(start);
				return;
			}
		}
		
		comp.setCaretPosition(0);
	}
}
