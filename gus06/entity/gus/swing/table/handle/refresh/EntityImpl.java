package gus06.entity.gus.swing.table.handle.refresh;

import gus06.framework.*;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170412";}
	
	
	public void p(Object obj) throws Exception
	{
		JTable table = (JTable) obj;
		AbstractTableModel model = (AbstractTableModel) table.getModel();
		model.fireTableDataChanged();
	}
}
