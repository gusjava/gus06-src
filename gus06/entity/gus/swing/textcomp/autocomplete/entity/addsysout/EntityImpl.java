package gus06.entity.gus.swing.textcomp.autocomplete.entity.addsysout;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Map;


public class EntityImpl implements Entity, V, P {

	public String creationDate() {return "20140825";}
	
	

	public EntityImpl() throws Exception
	{
	}

	
	
	public void p( Object obj) throws Exception
	{v("",obj);}

	
	
	public void v(String key, Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		String text = comp.getText();
		int pos = comp.getCaretPosition();
		
		StringBuffer b = new StringBuffer();
		
		b.append("System.out.println(\"");
		int delta = b.length();
		b.append(key+"\");");
		
		comp.getDocument().insertString(pos,b.toString(),null);
		comp.setCaretPosition(pos+delta);
	}
}
