package gus06.entity.gus.swing.textcomp.cust.action.alt_up.gotoup.perform;

import gus06.framework.*;
import javax.swing.text.*;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160512";}
	
	
	
	private Service performSelection;
	private Service performCaret;

	public EntityImpl() throws Exception
	{
		performSelection = Outside.service(this,"gus.swing.textcomp.cust.action.alt_up.gotoup.perform.selection");
		performCaret = Outside.service(this,"gus.swing.textcomp.cust.action.alt_up.gotoup.perform.caret");
	}
		
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof JTextArea)
		perform((JTextComponent) obj);
	}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		if(hasSelection(comp))
		{
			performSelection.p(comp);
			return;
		}
		performCaret.p(comp);
	}
	
	
	private boolean hasSelection(JTextComponent comp)
	{
		String s = comp.getSelectedText();
		return s!=null && !s.equals("");
	}
}
