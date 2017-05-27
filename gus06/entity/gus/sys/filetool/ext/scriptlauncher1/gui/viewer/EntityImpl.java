package gus06.entity.gus.sys.filetool.ext.scriptlauncher1.gui.viewer;

import gus06.framework.*;
import javax.swing.JTabbedPane;
import java.io.File;
import javax.swing.JComponent;

public class EntityImpl implements Entity, P, I {

	public String creationDate() {return "20161111";}


	private Service fileViewer;
	private Service dirViewer;

	private JTabbedPane tab;
	

	public EntityImpl() throws Exception
	{
		fileViewer = Outside.service(this,"*gus.file.editor.ext.gus");
		dirViewer = Outside.service(this,"*gus.dir.explorer.simple");
		
		tab = new JTabbedPane();
		tab.addTab("Script",(JComponent) fileViewer.i());
		tab.addTab("Directory",(JComponent) dirViewer.i());
	}
	
	
	public Object i() throws Exception
	{return tab;}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj==null)
		{
			fileViewer.p(null);
			dirViewer.p(null);
			return;
		}
		
		File file = (File) obj;
		File dir = file.getParentFile();
		
		fileViewer.p(file);
		dirViewer.p(dir);
	}
}
