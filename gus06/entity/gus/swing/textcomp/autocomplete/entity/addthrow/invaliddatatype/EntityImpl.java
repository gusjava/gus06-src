package gus06.entity.gus.swing.textcomp.autocomplete.entity.addthrow.invaliddatatype;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Map;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160812";}
	
	public static final String LINE = "throw new Exception(\"Invalid data type: \"+obj.getClass().getName());";

	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		int pos = comp.getCaretPosition();
		
		comp.getDocument().insertString(pos,LINE,null);
	}
}
