package gus06.entity.gus.swing.combobox.cust.white;

import gus06.framework.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141123";}

	
	public void p(Object obj) throws Exception
	{init((JComboBox) obj);}
	
	
	private void init(JComboBox combo)
	{
		combo.setRenderer(new Renderer());
		combo.setFont(combo.getFont().deriveFont(Font.PLAIN));
		combo.setBackground(Color.WHITE);
	}


	private class Renderer extends JLabel implements ListCellRenderer
	{
		public Renderer()
		{
			setOpaque(true);
			setFont(getFont().deriveFont(Font.PLAIN));
		}

		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
		{
			String s = (String)value;
			if(s==null || s.equals(""))setText(" ");
			else setText(s);
			
			if(isSelected) setBackground(Color.LIGHT_GRAY);
			else setBackground(Color.WHITE);
			return this;
		}
	}
}
