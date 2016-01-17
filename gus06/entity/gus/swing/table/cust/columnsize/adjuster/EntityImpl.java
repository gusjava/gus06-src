package gus06.entity.gus.swing.table.cust.columnsize.adjuster;

import javax.swing.JTable;
import gus06.framework.*;

public class EntityImpl implements Entity, P {


	public String creationDate() {return "20150623";}
	
	public void p(Object obj) throws Exception
	{new AdjusterHandler((JTable)obj);}
}
