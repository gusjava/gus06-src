package gus06.entity.gus.swing.table.renderer.builder1;

import gus06.framework.*;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JLabel;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170414";}

	
	public Object t(Object obj) throws Exception
	{return new TableCellRenderer1((T) obj);}
	
	
	
	private class TableCellRenderer1 implements TableCellRenderer
	{
		T t;
		boolean failed = false;
		JLabel label = new JLabel("#");
		
		public TableCellRenderer1(T t){this.t = t;}
		
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		{
			if(failed) return label;
			
			Map map = new HashMap();
			map.put("table",table);
			map.put("value",value);
			map.put("isSelected",new Boolean(isSelected));
			map.put("hasFocus",new Boolean(hasFocus));
			map.put("row",new Integer(row));
			map.put("column",new Integer(column));
			
			return mapToComp(this,map);
		}
	}
	
	
	private Component mapToComp(TableCellRenderer1 r, Map map)
	{
		try{return (Component) r.t.t(map);}
		catch(Exception e)
		{
			Outside.err(this,"mapToComp(TableCellRenderer1,Map)",e);
			r.failed = true;
		}
		return r.label;
	}
}
