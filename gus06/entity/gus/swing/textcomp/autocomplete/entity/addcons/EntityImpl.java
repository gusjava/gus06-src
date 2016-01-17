package gus06.entity.gus.swing.textcomp.autocomplete.entity.addcons;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Map;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140825";}
	
	
	private Service extractStructure;

	public EntityImpl() throws Exception
	{
		extractStructure = Outside.service(this,"gus.java.srccode.extract.entity.structure1");
	}

	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		String text = comp.getText();
		
		Map struct = (Map) extractStructure.t(text);
		if(struct.containsKey("constructor")) return;
		
		StringBuffer b = new StringBuffer();
		
		b.append("public EntityImpl() throws Exception\n");
		b.append("\t{\n");
		b.append("\t\t\n");
		
		int delta = b.length()-1;
		
		b.append("\t}\n");
		
		int pos = comp.getCaretPosition();
		comp.getDocument().insertString(pos,b.toString(),null);
		comp.setCaretPosition(pos+delta);
	}
}
