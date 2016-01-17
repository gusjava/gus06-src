package gus06.entity.gus.appli.gusexplorer.gui.maingui.dnd;

import gus06.framework.*;
import javax.swing.JComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141208";}


	private Service bgPaint;
	private Service dnd;
	private Service manager;
	
	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
		bgPaint = Outside.service(this,"gus.swing.comp.graphics.cust3.icon.dnd1");
		dnd = Outside.service(this,"gus.awt.dnd");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JComponent comp = (JComponent) obj;
		
		((V) comp).v("bgPaint",bgPaint);

		dnd.v("p",manager);
		dnd.v("g",null);
		dnd.p(comp);
	}
}
