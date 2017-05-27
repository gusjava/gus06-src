package gus06.entity.gus.sys.autocomplete1.editor1.date;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160622";}
	

	
	
	public EntityImpl() throws Exception
	{
	}

	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		String text = comp.getSelectedText();
		
		//A FAIRE ...
		// détecter des formats de date FR / EN
		
	}
}
