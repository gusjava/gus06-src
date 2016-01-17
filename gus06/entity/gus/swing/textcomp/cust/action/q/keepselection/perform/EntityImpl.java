package gus06.entity.gus.swing.textcomp.cust.action.q.keepselection.perform;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151105";}


	private Service selection;
	private Service caret;


	public EntityImpl() throws Exception
	{
		selection = Outside.service(this,"gus.swing.textcomp.cust.action.q.keepselection.perform.selection");
		caret = Outside.service(this,"gus.swing.textcomp.cust.action.q.keepselection.perform.caret");
	}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof JTextArea)
		perform((JTextComponent) obj);
	}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		if(hasSelection(comp)) selection.p(comp);
		else caret.p(comp);
	}
	
	
	private boolean hasSelection(JTextComponent comp)
	{
		String s = comp.getSelectedText();
		return s!=null && !s.equals("");
	}
}
