package gus06.entity.gus.file.editor.ext.properties.gui;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Map;


public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20141229";}

	
	private Service form;
	private Service table;
	private Service label;
	private Service button;
	
	private JPanel panel;
	
	private Map map;
	
	

	public EntityImpl() throws Exception
	{
		form = Outside.service(this,"*gus.file.editor.ext.properties.form");
		table = Outside.service(this,"*gus.file.editor.ext.properties.table");
		label = Outside.service(this,"*gus.file.editor.ext.properties.label");
		button = Outside.service(this,"*gus.file.editor.ext.properties.button");
		
		JPanel p_bottom = new JPanel(new BorderLayout());
		p_bottom.add((JComponent) label.i(),BorderLayout.CENTER);
		p_bottom.add((JComponent) button.i(),BorderLayout.EAST);
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) form.i(),BorderLayout.NORTH);
		panel.add((JComponent) table.i(),BorderLayout.CENTER);
		panel.add(p_bottom,BorderLayout.SOUTH);
		
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		map = (Map) obj;
		
		form.p(map);
		table.p(map);
		label.p(map);
		button.p(map);
	}
}
