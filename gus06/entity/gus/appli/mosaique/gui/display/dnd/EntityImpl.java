package gus06.entity.gus.appli.mosaique.gui.display.dnd;

import gus06.framework.*;
import javax.swing.JComponent;
import java.util.List;
import java.io.File;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141116";}


	private Service dnd;
	private Service dataFile;
	private Service dataDir;
	private Service trigger;
	private Service refresh;
	
	
	private P holder;


	public EntityImpl() throws Exception
	{
		dnd = Outside.service(this,"gus.awt.dnd");
		dataFile = Outside.service(this,"gus.appli.mosaique.data.file");
		dataDir = Outside.service(this,"gus.appli.mosaique.data.dir");
		trigger = Outside.service(this,"gus.appli.mosaique.engine.trigger");
		refresh = Outside.service(this,"gus.swing.comp.cust3.execute.f5");
		
		holder = new P() {
			public void p(Object obj) throws Exception
			{
				if(obj instanceof List)
				handleList((List) obj);
			}
		};
	}
	
	
	public void p(Object obj) throws Exception
	{
		JComponent comp = (JComponent) obj;
		
		dnd.v("p",holder);
		dnd.v("g",null);
		dnd.p(comp);
		
		refresh.p(new Object[]{comp,trigger});
	}
	
	
	private void handleList(List list) throws Exception
	{
		File file = (File) list.get(0);
		
		if(!file.exists()) return;
		if(file.isFile()) dataFile.p(file);
		else dataDir.p(file);
		
		trigger.e();
	}
}
