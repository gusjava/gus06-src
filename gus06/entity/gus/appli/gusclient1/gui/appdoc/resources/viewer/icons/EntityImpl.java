package gus06.entity.gus.appli.gusclient1.gui.appdoc.resources.viewer.icons;

import gus06.framework.*;
import javax.swing.JComponent;
import java.util.Map;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140910";}

	
	private Service findIconMap;
	private Service mapViewer;
	
	private Map map;
	
	
	
	public EntityImpl() throws Exception
	{
		findIconMap = Outside.service(this,"gus.app.jarfile.listing.resources.iconmap.gyem");
		mapViewer = Outside.service(this,"*gus.data.viewer.map.iconmap");
		
		map = (Map) findIconMap.g();
		mapViewer.p(map);
	}
	
	
	
	public Object i() throws Exception
	{return mapViewer.i();}
}
