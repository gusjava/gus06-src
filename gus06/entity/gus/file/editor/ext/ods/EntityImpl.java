package gus06.entity.gus.file.editor.ext.ods;

import gus06.framework.*;
import java.io.File;
import org.jopendocument.model.OpenDocument;
import org.jopendocument.panel.ODSViewerPanel;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20170304";}


	private Service shiftPanel;

	private File file;
	
	public EntityImpl() throws Exception
	{
		shiftPanel = Outside.service(this,"gus.swing.panel.shiftpanel");
	}
	
	
	public Object i() throws Exception
	{return shiftPanel.i();}
	
	
	public Object g() throws Exception
	{return file;}
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		
		if(file==null || !file.isFile())
			shiftPanel.p(null);
		else
		{
			OpenDocument doc = new OpenDocument(file);
			ODSViewerPanel viewer = new ODSViewerPanel(doc);
			shiftPanel.p(viewer);
		}
	}
}
