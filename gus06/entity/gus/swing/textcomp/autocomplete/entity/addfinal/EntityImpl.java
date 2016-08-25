package gus06.entity.gus.swing.textcomp.autocomplete.entity.addfinal;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Map;


public class EntityImpl implements Entity, V {

	public String creationDate() {return "20160424";}

	
	
	public void v(String key, Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		int pos = comp.getCaretPosition();
		
		String key1 = key.replace(" ","_").toUpperCase();
		String line = "public static final String "+key1+" = \""+key1+"\";";
		
		comp.getDocument().insertString(pos,line,null);
		comp.setCaretPosition(pos+line.length());
	}
}
