package gus06.entity.gus.swing.textcomp.cust.action.alt_t.truncate.perform;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160830";}


	private Service performSelectionMono;
	private Service performSelectionMulti;
	private Service performCaret;

	public EntityImpl() throws Exception
	{
		performSelectionMono = Outside.service(this,"gus.swing.textcomp.cust.action.alt_t.truncate.perform.selection.mono");
		performSelectionMulti = Outside.service(this,"gus.swing.textcomp.cust.action.alt_t.truncate.perform.selection.multi");
		performCaret = Outside.service(this,"gus.swing.textcomp.cust.action.alt_t.truncate.perform.caret");
	}
		
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof JTextArea)
		perform((JTextComponent) obj);
	}
	
	
	
	private void perform(JTextComponent comp) throws Exception
	{
		if(hasSelectionMulti(comp))
		{
			performSelectionMulti.p(comp);
			return;
		}
		if(hasSelection(comp))
		{
			performSelectionMono.p(comp);
			return;
		}
		performCaret.p(comp);
	}
	
	
	private boolean hasSelection(JTextComponent comp)
	{
		String s = comp.getSelectedText();
		return s!=null && !s.equals("");
	}
	
	private boolean hasSelectionMulti(JTextComponent comp)
	{
		String s = comp.getSelectedText();
		return s!=null && s.contains("\n");
	}
}
