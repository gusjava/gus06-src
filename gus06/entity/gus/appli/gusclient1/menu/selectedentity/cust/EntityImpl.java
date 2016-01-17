package gus06.entity.gus.appli.gusclient1.menu.selectedentity.cust;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140801";}

	private Service compCust;
	private Service selection;
	
	public EntityImpl() throws Exception
	{
		compCust = Outside.service(this,"gus.swing.comp.cust3.enable");
		selection = Outside.service(this,"gus.appli.gusclient1.gui.entity.holder");
	}
	
	
	public void p(Object obj) throws Exception
	{
		compCust.p(new Object[]{obj,selection});
	}
}
