package gus06.entity.gus.swing.table.cust.sort2;

import gus06.framework.*;
import javax.swing.JTable;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150430";}
	
	
	public void p(Object obj) throws Exception
	{
		JTable table = (JTable) obj;
		table.setAutoCreateRowSorter(true);
	}
}
