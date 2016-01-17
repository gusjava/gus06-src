package gus06.entity.gus.swing.label.cust.popup.menu1;

import gus06.framework.*;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140821";}


	private Service popupMenuBuilder;
	private Service copyActionBuilder;
	
	public EntityImpl() throws Exception
	{
		popupMenuBuilder = Outside.service(this,"gus.swing.popupmenu.builder1");
		copyActionBuilder = Outside.service(this,"gus.swing.label.build.action.copy");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JLabel label = (JLabel) obj;
		
		JPopupMenu popupMenu = (JPopupMenu) popupMenuBuilder.t(label);
		Action action =(Action) copyActionBuilder.t(label);
		
		popupMenu.add(action);
	}
}
