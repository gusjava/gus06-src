package gus06.entity.gus.swing.popupmenu.builder1;

import gus06.framework.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140821";}

	
	
	public Object t(Object obj) throws Exception
	{
		JComponent comp = (JComponent) obj;
		JPopupMenu menu = new JPopupMenu();
		comp.addMouseListener(new PopupAdapter(menu));
		return menu;
	}
	
	
	
	private class PopupAdapter extends MouseAdapter
	{
		private JPopupMenu popup;
        
		public PopupAdapter(JPopupMenu popup) 
		{this.popup = popup;}
        
		public void mousePressed(MouseEvent e) {maybeShowPopup(e);}
		public void mouseReleased(MouseEvent e) {maybeShowPopup(e);}
        
		private void maybeShowPopup(MouseEvent e)
		{
			if(e.isPopupTrigger())
			{popup.show(e.getComponent(),e.getX(),e.getY());}
		}
	}
}
