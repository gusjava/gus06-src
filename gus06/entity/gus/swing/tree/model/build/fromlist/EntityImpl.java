package gus06.entity.gus.swing.tree.model.build.fromlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150609";}


	
	public Object t(Object obj) throws Exception
	{return new TreeModel0(obj);}

	
	
	private class TreeModel0 implements TreeModel
	{ 
		private Object root;
		
		public TreeModel0(Object root)
		{this.root = root;}

		public Object getRoot()
		{return root;}
		

		public Object getChild(Object parent, int index)
		{
			List list = toList(parent);
			if(list==null || list.size()<=index) return null;
			return list.get(index);
		}
		
		public int getIndexOfChild(Object parent, Object child)
		{
			List list = toList(parent);
			if(list==null) return -1;
			return list.indexOf(child);
		}

		public int getChildCount(Object parent)
		{
			if(parent instanceof Collection) return ((Collection) parent).size();
			if(parent instanceof Map) return ((Map) parent).size();
			return 0;
		}

		public boolean isLeaf(Object node)
		{return getChildCount(node)==0;}
		

		public void addTreeModelListener(TreeModelListener l) {}
		public void removeTreeModelListener(TreeModelListener l) {}
		public void valueForPathChanged(TreePath path, Object newValue) {}
	}
	
	
	private List toList(Object obj)
	{
		if(obj instanceof List) return (List) obj;
		if(obj instanceof Map) return mapToList((Map) obj);
		if(obj instanceof Object[]) return Arrays.asList((Object[]) obj);
		if(obj instanceof String[]) return Arrays.asList((String[]) obj);
		
		return null;
	}
	
	
	private List mapToList(Map map)
	{
		List values = new ArrayList();
		List keys = new ArrayList(map.keySet());
		Collections.sort(keys);
		
		for(int i=0;i<keys.size();i++)
		{
			Object value = map.get(keys.get(i));
			values.add(value);
		}
		return values;
	}
}
