package gus06.entity.gus.swing.textcomp.autocomplete.entity.addthrow.unknownkey;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Map;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160812";}
	
	public static final String LINE = "throw new Exception(\"Unknown key: \"+key);";

	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		int pos = comp.getCaretPosition();
		
		comp.getDocument().insertString(pos,LINE,null);
	}
}
