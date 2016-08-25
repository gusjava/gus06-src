package gus06.entity.gus.swing.label.cust.onrollover.bgwhite;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160501";}


	
	public void p(Object obj) throws Exception
	{new Holder((JLabel) obj);}


	
	private class Holder implements MouseListener
	{
		private JLabel label;
		private Color background;
		private boolean isOpaque;
		
		public Holder(JLabel label)
		{
			this.label = label;
			label.setFocusable(true);
			label.addMouseListener(this);
		}

		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		
		public void mouseEntered(MouseEvent e)
		{
			background = label.getBackground();
			isOpaque = label.isOpaque();
			
			label.setBackground(Color.WHITE);
			label.setOpaque(true);
			label.requestFocusInWindow();
		}
		public void mouseExited(MouseEvent e)
		{
			label.setBackground(background);
			label.setOpaque(isOpaque);
		}
	}
}
