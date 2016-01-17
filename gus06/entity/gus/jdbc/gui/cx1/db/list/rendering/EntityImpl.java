package gus06.entity.gus.jdbc.gui.cx1.db.list.rendering;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150622";}

	
	public static final Color COLOR_MYSQLDB = new Color(204,102,0);
	public static final Color SELECTION_COLOR = new Color(210,235,235);
	
	
	
	private Icon icon;
	
	

	public EntityImpl() throws Exception
	{
		icon = (Icon) Outside.resource(this,"icon#BASE");
	}



	public void p(Object obj) throws Exception
	{
		JList list = (JList) obj;
		list.setCellRenderer(new ListRenderer0());
	}

	
	
	
	
	
	private class ListRenderer0 extends JLabel implements ListCellRenderer
	{   
		public ListRenderer0()
		{
			super();
			setOpaque(true);
			setBackground(Color.WHITE);
			setIcon(icon);
			setFont(getFont().deriveFont(Font.PLAIN));
		}

		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
		{
			String dbName = (String) value;

			setText(dbName);
			setForeground(foreground(dbName));
			setBackground(background(isSelected));
			return this;
		}
	}
	
	
	
	private Color foreground(String dbName)
	{
		if(isMysqlDb(dbName))
			return COLOR_MYSQLDB;
		return Color.BLACK;
	}
	
	private Color background(boolean isSelected)
	{
		if(isSelected) 
			return SELECTION_COLOR;
		return Color.WHITE;
	}
	
	
	
	
	private boolean isMysqlDb(String dbName)
	{return dbName.equals("mysql") || dbName.equals("information_schema") || dbName.equals("performance_schema");}
	

}
