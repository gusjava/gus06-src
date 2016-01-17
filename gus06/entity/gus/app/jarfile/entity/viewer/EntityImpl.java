package gus06.entity.gus.app.jarfile.entity.viewer;

import gus06.framework.*;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComponent;


public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140829";}


	private Service srcPanel;
	private Service docPanel;
	private Service entityLabel;
	private Service splitCust;


	private JPanel panel;
	private JSplitPane split;
	
	private String name;
	
	
	public EntityImpl() throws Exception
	{
		srcPanel = Outside.service(this,"*gus.app.jarfile.entity.viewer.panel.src");
		docPanel = Outside.service(this,"*gus.app.jarfile.entity.viewer.panel.doc");
		entityLabel = Outside.service(this,"*gus.app.entity.label");
		splitCust = Outside.service(this,"gus.swing.splitpane.cust.cust1");
		
		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitCust.p(split);
		
		split.setLeftComponent((JComponent) srcPanel.i());
		split.setRightComponent((JComponent) docPanel.i());
		
		split.setDividerLocation(250);
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) entityLabel.i(),BorderLayout.NORTH);
		panel.add(split,BorderLayout.CENTER);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		name = (String) obj;
		entityLabel.p(name);
		srcPanel.p(name);
		docPanel.p(name);
	}
}
