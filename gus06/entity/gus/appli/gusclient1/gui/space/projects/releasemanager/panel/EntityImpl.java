package gus06.entity.gus.appli.gusclient1.gui.space.projects.releasemanager.panel;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import java.io.File;

public class EntityImpl implements Entity, P, I {

	public String creationDate() {return "20141015";}


	private Service explorer;
	private Service description;
	private Service snapShots;
	private Service online;
	
	private JTabbedPane tab;
	private File dir;
	
	public EntityImpl() throws Exception
	{
		explorer = Outside.service(this,"*gus.dir.explorer.simple");
		description = Outside.service(this,"*gus.appli.gusclient1.project.release.gui.description");
		snapShots = Outside.service(this,"*gus.appli.gusclient1.project.release.gui.snapshots");
		online = Outside.service(this,"*gus.appli.gusclient1.project.release.gui.online");
		
		tab = new JTabbedPane();
		tab.addTab("Explorer",(JComponent) explorer.i());
		tab.addTab("Description",(JComponent) description.i());
		tab.addTab("Snapshots",(JComponent) snapShots.i());
		tab.addTab("Online",(JComponent) online.i());
	}
	
	
	public Object i() throws Exception
	{return tab;}
	
	
	public void p(Object obj) throws Exception
	{
		dir = (File) obj;
		
		explorer.p(dir);
		description.p(dir);
		snapShots.p(dir);
		online.p(dir);
	}
}
