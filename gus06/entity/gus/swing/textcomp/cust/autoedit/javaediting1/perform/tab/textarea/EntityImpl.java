package gus06.entity.gus.swing.textcomp.cust.autoedit.javaediting1.perform.tab.textarea;

import gus06.framework.*;
import javax.swing.text.JTextComponent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140816";}

	private Map map;
	
	public EntityImpl() throws Exception
	{
	}
	
	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		
		
	}
	
	
	
	private void insert(JTextComponent comp, int pos, String s) throws Exception
	{comp.getDocument().insertString(pos,s,null);}
}
