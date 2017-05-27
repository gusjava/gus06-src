package gus06.entity.gus.data.perform.rotate180;

import gus06.framework.*;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import java.awt.image.RenderedImage;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161126";}


	private Service rotateJPanel;
	private Service rotateJTabbedPane;
	private Service rotateJSplitPane;
	private Service rotateImage;
	
	public EntityImpl() throws Exception
	{
		rotateJPanel = Outside.service(this,"gus.swing.panel.rotate180.grid");
		rotateJTabbedPane = Outside.service(this,"gus.swing.tabbedpane.rotate180");
		rotateJSplitPane = Outside.service(this,"gus.swing.splitpane.rotate180");
		rotateImage = Outside.service(this,"gus.awt.renderedimage.transform.rotate180");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof JPanel) return rotateJPanel.t(obj);
		if(obj instanceof JTabbedPane) return rotateJTabbedPane.t(obj);
		if(obj instanceof JSplitPane) return rotateJSplitPane.t(obj);
		if(obj instanceof RenderedImage) return rotateImage.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
