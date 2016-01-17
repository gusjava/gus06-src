package gus06.entity.gus.swing.textcomp.autocomplete.entity.adddataarray;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Map;


public class EntityImpl implements Entity, P, V {

	public String creationDate() {return "20140831";}

	
	public void p(Object obj) throws Exception
	{v("2",obj);}
	
	
	public void v(String key, Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		String text = comp.getText();
		int pos = comp.getCaretPosition();
		
		StringBuffer b = new StringBuffer();
		
		b.append("Object[] o = (Object[]) obj;\n");
		b.append("\t\tif(o.length!="+key+") throw new Exception(\"Wrong data number: \"+o.length);\n");
		b.append("\t\t");
		
		comp.getDocument().insertString(pos,b.toString(),null);
	}
}
