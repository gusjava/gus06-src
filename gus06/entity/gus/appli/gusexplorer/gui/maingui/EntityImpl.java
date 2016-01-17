package gus06.entity.gus.appli.gusexplorer.gui.maingui;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;


public class EntityImpl implements Entity, I {

	public String creationDate() {return "20141206";}

	private Service guiTabbedPane;
	private Service handleDnd;
	private Service bottomGui;

	private JPanel panel;
	private JTabbedPane tabbedPane;



	public EntityImpl() throws Exception
	{
    		guiTabbedPane = Outside.service(this,"*gus.appli.gusexplorer.gui.tabbedpane");
		handleDnd = Outside.service(this,"gus.appli.gusexplorer.gui.maingui.dnd");
		bottomGui = Outside.service(this,"*gus.appli.gusexplorer.gui.bottombar");

		tabbedPane = (JTabbedPane) guiTabbedPane.i();
		handleDnd.p(tabbedPane);

		panel = new JPanel(new BorderLayout());
        	panel.add(tabbedPane,BorderLayout.CENTER);
        	panel.add((JComponent) bottomGui.i(),BorderLayout.SOUTH);
	}
	
	
	public Object i() throws Exception
	{return panel;}
}
