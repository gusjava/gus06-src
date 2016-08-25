package gus06.entity.gus.sys.autocomplete1.rm.all;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P, V {

	public String creationDate() {return "20160519";}

	
	
	public void v(String key, Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		String text = comp.getText();
		int pos = comp.getCaretPosition();
		
		text = text.replace(key,"");
		
		pos = Math.min(pos,text.length());
		comp.setText(text);
		comp.setCaretPosition(pos);
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		String s = comp.getSelectedText();
		if(s==null || s.equals("")) return;
		
		v(s,comp);
	}
}
