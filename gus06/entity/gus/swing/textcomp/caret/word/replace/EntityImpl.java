package gus06.entity.gus.swing.textcomp.caret.word.replace;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import java.util.Vector;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20140915";}


	private Service getRange;

	public EntityImpl() throws Exception
	{
		getRange = Outside.service(this,"gus.swing.textcomp.caret.word.range");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		int pos = comp.getCaretPosition();
		int[] range = (int[]) getRange.t(comp);
		
		int maxPos = range[0]+1+key.length();
		int newPos = Math.min(pos,maxPos);
		
		String text = comp.getText();
		String newText = text.substring(0,range[0]+1) + key + text.substring(range[1]);
		
		comp.setText(newText);
		comp.setCaretPosition(newPos);
	}
}
