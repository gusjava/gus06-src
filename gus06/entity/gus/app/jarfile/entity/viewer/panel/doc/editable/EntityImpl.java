package gus06.entity.gus.app.jarfile.entity.viewer.panel.doc.editable;

import gus06.framework.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Event;
import javax.swing.text.JTextComponent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;


public class EntityImpl implements Entity, P, V {

	public String creationDate() {return "20140829";}

	public static final KeyStroke KEYSTROKE = KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK);
	
	private Service register;


	private JTextComponent comp;
	private String name;
	
	public EntityImpl() throws Exception
	{
		register = Outside.service(this,"gus.ling.gui.lingdir.register");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		comp = (JTextComponent) obj;
		comp.setEditable(true);
		
		AbstractAction action = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {save();}
		};
		comp.getInputMap().put(KEYSTROKE,action);
	}
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("name")) {name = (String) obj;return;}
		throw new Exception("Unknown key: "+key);
	}



	private void save()
	{
		try
		{
			if(name==null) return;
			String text = comp.getText();
			
			register.v(lingKey(),text);
		}
		catch(Exception e)
		{Outside.err(this,"save()",e);}
	}


	private String lingKey()
	{return "doc1_entity_"+name;}
}
