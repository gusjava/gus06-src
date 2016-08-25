package gus06.entity.gus.appli.laboscript.gui.consolegui;

import gus06.framework.*;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20160623";}


	private Service gui1;
	private Service viewer;

	private JPanel panel;
	private JComponent gui1Comp;
	private JComponent viewerComp;
	

	public EntityImpl() throws Exception
	{
		gui1 = Outside.service(this,"*gus.appli.laboscript.gui.consolegui.gui1");
		viewer = Outside.service(this,"*gus.data.viewer.map");
		
		gui1Comp = (JComponent) gui1.i();
		viewerComp = (JComponent) viewer.i();
		
		panel = new JPanel(new BorderLayout());
		panel.add(gui1Comp,BorderLayout.CENTER);
		panel.add(viewerComp,BorderLayout.EAST);
		
		viewerComp.setMaximumSize(new Dimension(200,0));
		
		gui1.addActionListener(this); 
		updateViewer();
	}
	
	
	public Object i() throws Exception
	{return panel;}


	public void actionPerformed(ActionEvent e)
	{updateViewer();}
	
	
	private void updateViewer()
	{
		try{viewer.p(gui1.r("input"));}
		catch(Exception e)
		{Outside.err(this,"updateViewer()",e);}
	}

}
