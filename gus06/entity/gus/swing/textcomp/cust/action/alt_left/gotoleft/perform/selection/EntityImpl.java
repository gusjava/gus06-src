package gus06.entity.gus.swing.textcomp.cust.action.alt_left.gotoleft.perform.selection;

import gus06.framework.*;
import javax.swing.text.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160903";}

	
	
	public void p(Object obj) throws Exception
	{perform((JTextComponent) obj);}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		String selection = comp.getSelectedText();
		String text = comp.getText();
		int p = comp.getSelectionStart();
		
		String text1 = text.substring(0,p);
		int offset = text1.lastIndexOf(selection);
		
		if(offset==-1) return;
		
		comp.setSelectionStart(offset);
		comp.setSelectionEnd(offset+selection.length());
	}
}
