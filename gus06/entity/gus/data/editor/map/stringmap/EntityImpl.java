package gus06.entity.gus.data.editor.map.stringmap;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Map;
import java.util.HashMap;


public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20150329";}

	
	private Service form;
	private Service table;
	private Service label;
	private Service button;
	
	private JPanel panel;
	
	private Map map;
	
	

	public EntityImpl() throws Exception
	{
		form = Outside.service(this,"*gus.data.editor.map.stringmap.form");
		table = Outside.service(this,"*gus.data.editor.map.stringmap.table");
		label = Outside.service(this,"*gus.data.editor.map.stringmap.label");
		button = Outside.service(this,"*gus.data.editor.map.stringmap.button");
		
		map = (Map) Outside.resource(this,"supportmap");
		
		form.p(map);
		table.p(map);
		label.p(map);
		button.p(map);
		
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
		Map m = (Map) obj;
		
		map.clear();
		if(m!=null) map.putAll(m);
	}
	
	
	public Object g() throws Exception
	{return new HashMap(map);}
}
