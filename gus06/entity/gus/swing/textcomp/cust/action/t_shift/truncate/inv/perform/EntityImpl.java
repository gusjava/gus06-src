package gus06.entity.gus.swing.textcomp.cust.action.t_shift.truncate.inv.perform;

import gus06.framework.*;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150824";}


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
		PlainDocument document = (PlainDocument) comp.getDocument();
		int p = comp.getCaretPosition();
		String text = comp.getText(p,document.getLength()-p);
		comp.setText(text);
		comp.setCaretPosition(0);
	}
}
