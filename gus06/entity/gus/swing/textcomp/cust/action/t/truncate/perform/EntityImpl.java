package gus06.entity.gus.swing.textcomp.cust.action.t.truncate.perform;

import gus06.framework.*;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141114";}


	public EntityImpl() throws Exception
	{
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
			String text = comp.getSelectedText();
			comp.setText(text);
		}
		else
		{
			int p = comp.getCaretPosition();
			String text = comp.getText(0,p);
			comp.setText(text);
		}
	}
	
	
	private boolean hasSelection(JTextComponent comp)
	{
		String s = comp.getSelectedText();
		return s!=null && !s.equals("");
	}
}
