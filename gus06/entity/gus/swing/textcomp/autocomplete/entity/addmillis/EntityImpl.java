package gus06.entity.gus.swing.textcomp.autocomplete.entity.addmillis;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Map;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150919";}
	
	

	public EntityImpl() throws Exception
	{
	}

	
	
	public void p( Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		String text = comp.getText();
		int pos = comp.getCaretPosition();
		
		StringBuffer b = new StringBuffer();
		
		b.append("System.currentTimeMillis()");
		int delta = b.length();
		
		comp.getDocument().insertString(pos,b.toString(),null);
		comp.setCaretPosition(pos+delta);
	}
}
