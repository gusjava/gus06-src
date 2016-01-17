package gus06.entity.gus.sys.base1.gui.viewer1;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

public class EntityImpl implements Entity, ActionListener, I, P {

	public String creationDate() {return "20150329";}


	private Service listView;
	private Service mapEditor;


	private Object base;
	private String selectedId;
	private Map selectedMap;
	
	private JPanel panel;
	private JLabel label_list;
	private JLabel label_selected;
	
	private JButton button_add;
	private JButton button_remove;
	private JButton button_modify;
	private JButton button_refresh;
	private JButton button_clear;


	public EntityImpl() throws Exception
	{
		listView = Outside.service(this,"*gus.data.collection.guilist1");
		mapEditor = Outside.service(this,"*gus.data.editor.map.stringmap");
		
		
		label_list = new JLabel("List");
		label_list.setHorizontalAlignment(JLabel.CENTER);
		label_list.setBorder(BorderFactory.createRaisedBevelBorder());
		
		label_selected = new JLabel(" ");
		label_selected.setHorizontalAlignment(JLabel.CENTER);
		label_selected.setBorder(BorderFactory.createRaisedBevelBorder());
		
		
		
		button_add = new JButton("add");
		button_add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{add();}
		});
		
		button_remove = new JButton("remove");
		button_remove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{remove();}
		});
		
		button_modify = new JButton("modify");
		button_modify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{modify();}
		});
		
		button_refresh = new JButton("refresh");
		button_refresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{refresh();}
		});
		
		button_clear = new JButton("clear");
		button_clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{clear();}
		});
		
		
		
		JPanel p_bottom = new JPanel(new GridLayout(1,0));
		p_bottom.add(button_add);
		p_bottom.add(button_remove);
		p_bottom.add(button_modify);
		p_bottom.add(button_refresh);
		p_bottom.add(button_clear);
		
		
		JPanel p_left = new JPanel(new BorderLayout());
		p_left.add(label_list,BorderLayout.NORTH);
		p_left.add((JComponent) listView.i(),BorderLayout.CENTER);
		
		JPanel p_right = new JPanel(new BorderLayout());
		p_right.add(label_selected,BorderLayout.NORTH);
		p_right.add((JComponent) mapEditor.i(),BorderLayout.CENTER);
		
		
		JSplitPane split = new JSplitPane();
		split.setDividerLocation(120);
		split.setLeftComponent(p_left);
		split.setRightComponent(p_right);
		
		panel = new JPanel(new BorderLayout());
		panel.add(split,BorderLayout.CENTER);
		panel.add(p_bottom,BorderLayout.SOUTH);
		
		listView.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	public void p(Object obj) throws Exception
	{
		base = obj;
		refresh();
	}


	public void actionPerformed(ActionEvent e)
	{selected();}
	
	
	
	
	
	private void refresh()
	{
		try
		{
			if(base==null) return;
			
			updateList();
			resetEditor();
		}
		catch(Exception e)
		{Outside.err(this,"refresh()",e);}
	}
	
	
	
	private void clear()
	{
		try
		{
			if(base==null) return;
			
			((E)base).e();
			
			updateList();
			resetEditor();
		}
		catch(Exception e)
		{Outside.err(this,"clear()",e);}
	}
	
	
	
	
	private void add()
	{
		try
		{
			if(base==null) return;
			
			((V)base).v("map",mapEditor.g());
			
			updateList();
			resetEditor();
		}
		catch(Exception e)
		{Outside.err(this,"add()",e);}
	}
	
	
	
	private void remove()
	{
		try
		{
			if(base==null) return;
			if(selectedId==null) return;
			
			((V)base).v("map_"+selectedId,null);
			
			updateList();
			resetEditor();
		}
		catch(Exception e)
		{Outside.err(this,"remove()",e);}
	}
	
	
	private void modify()
	{
		try
		{
			if(base==null) return;
			if(selectedId==null) return;
			
			selectedMap = (Map) mapEditor.g();
			((V)base).v("map_"+selectedId,selectedMap);
		}
		catch(Exception e)
		{Outside.err(this,"modify()",e);}
	}
	
	
	
	
	
	
	private void selected()
	{
		try
		{
			if(base==null) return;
			
			selectedId = (String) listView.g();
			selectedMap = (Map) ((R)base).r("map_"+selectedId);
			
			updateEditor();
		}
		catch(Exception e)
		{Outside.err(this,"selected()",e);}
	}
	
	
	
	
	
	private void updateList() throws Exception
	{
		listView.p(((G)base).g());
	}
	
	
	
	private void resetEditor() throws Exception
	{
		selectedId = null;
		selectedMap = null;
		updateEditor();
	}
	
	private void updateEditor() throws Exception
	{
		label_selected.setText(selectedId==null?" ":selectedId);
		mapEditor.p(selectedMap);
	}


}
