package gus06.entity.gus.swing.tree.cust.renderer.obj1;

import gus06.framework.*;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.Set;



public class EntityImpl implements Entity, P {

	public String creationDate() {return "20161221";}
	
	
	private Service iconProvider;

	public EntityImpl() throws Exception
	{iconProvider = Outside.service(this,"gus.icon.provider");}


	private Icon icon(String key)
	{
		try{return (Icon) iconProvider.r(key);}
		catch(Exception e){Outside.err(this,"icon(String)",e);}
		return null;
	}
	
	private Icon icon(boolean expanded)
	{return expanded?icon("dir_"):icon("dir");}
	
	

	public void p(Object obj) throws Exception
	{
		JTree tree = (JTree) obj;
		TreeCellRenderer renderer = tree.getCellRenderer();
		tree.setCellRenderer(new TreeCellRenderer0(renderer));
	}

	
	
	
	private void repaintLabel(JLabel label, String title, boolean expanded)
	{
		label.setIcon(icon(expanded));
		label.setText(title);
	}
	
	
	
	
	private class TreeCellRenderer0 implements TreeCellRenderer
	{
		private TreeCellRenderer renderer;
		public TreeCellRenderer0(TreeCellRenderer renderer)
		{this.renderer = renderer;}
		
		public Component getTreeCellRendererComponent(JTree tree,Object value,boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus)
		{
			JLabel label = (JLabel) renderer.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus);
			String display = findDisplay(value);
			repaintLabel(label,display,expanded);
			return label;
		}
	}
	
	
	
	private String findDisplay(Object value)
	{
		if(value==null) return "null";
		if(value instanceof Map) return "Map";
		if(value instanceof List) return "List";
		if(value instanceof Set) return "Set";
		if(value instanceof String) return value.toString().trim();
		if(value instanceof Map.Entry) return findDisplayEntry((Map.Entry) value);
		
		return value.getClass().getName();
	}
	
	private String findDisplayEntry(Map.Entry entry)
	{
		String key = findDisplay(entry.getKey());
		String value = findDisplay(entry.getValue());
		return key+":"+value;
	}
}
