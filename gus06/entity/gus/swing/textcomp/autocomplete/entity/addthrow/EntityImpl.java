package gus06.entity.gus.swing.textcomp.autocomplete.entity.addthrow;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Map;


public class EntityImpl implements Entity, V, P {

	public String creationDate() {return "20160424";}
	
	public static final String LINE = "throw new Exception(\"<MESSAGE>\");";
	public static final int D1 = 21;
	public static final int D2 = 30;

	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		int pos = comp.getCaretPosition();
		
		comp.getDocument().insertString(pos,LINE,null);
		comp.select(pos+D1,pos+D2);
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		int pos = comp.getCaretPosition();
		
		String line = LINE.replace("<MESSAGE>",key);
		comp.getDocument().insertString(pos,line,null);
		comp.setCaretPosition(pos+line.length());
	}
}
