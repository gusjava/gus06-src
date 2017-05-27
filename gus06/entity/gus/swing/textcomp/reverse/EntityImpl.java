package gus06.entity.gus.swing.textcomp.reverse;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20170317";}

	
	
	public Object t(Object obj) throws Exception
	{
		p(obj);
		return obj;
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		String text = comp.getText();
		
		StringBuffer b = new StringBuffer(text);
		comp.setText(b.reverse().toString());
	}
}
