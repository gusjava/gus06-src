package gus06.entity.gus.swing.textcomp.cust.action.ctrl_q.keepselection.perform;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151105";}


	private Service performSelection;
	private Service performCaret;
	private Service performFocus;
	private Service focusManager;


	public EntityImpl() throws Exception
	{
		performSelection = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_q.keepselection.perform.selection");
		performCaret = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_q.keepselection.perform.caret");
		performFocus = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_q.keepselection.perform.focus");
		focusManager = Outside.service(this,"gus.swing.textcomp.textfocus.manager");
	}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof JTextArea)
		perform((JTextComponent) obj);
	}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		if(focusManager.f(comp))
		{
			performFocus.p(comp);
			return;
		}
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
