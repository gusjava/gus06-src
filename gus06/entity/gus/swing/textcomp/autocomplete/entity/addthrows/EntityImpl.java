package gus06.entity.gus.swing.textcomp.autocomplete.entity.addthrows;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Map;


public class EntityImpl implements Entity, V {

	public String creationDate() {return "20140825";}
	
	

	public EntityImpl() throws Exception
	{
	}

	
	
	public void v(String key, Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		String text = comp.getText();
		int pos = comp.getCaretPosition();
		
		StringBuffer b = new StringBuffer();
		
		b.append("private void "+key+"() throws Exception\n");
		b.append("\t{\n");
		b.append("\t\t\n");
		
		int delta = b.length()-1;
		
		b.append("\t}\n");
		
		comp.getDocument().insertString(pos,b.toString(),null);
		comp.setCaretPosition(pos+delta);
	}
}
