package gus06.entity.gus.swing.tree.model.build.frommap2;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161221";}
	
	
	private Comparator entryComparator;
	
	public EntityImpl() throws Exception
	{
		entryComparator = new Comparator() {
			public int compare(Object o1, Object o2)
			{
				Map.Entry e1 = (Map.Entry) o1;
				Map.Entry e2 = (Map.Entry) o2;
				
				Comparable key1 = (Comparable) e1.getKey();
				Comparable key2 = (Comparable) e2.getKey();
				
				return key1.compareTo(key2);
			}
		};
	}


	
	public Object t(Object obj) throws Exception
	{return new TreeModel0((Map) obj);}

	
	
	private class TreeModel0 implements TreeModel
	{ 
		private Map root;
		
		public TreeModel0(Map root)
		{this.root = root;}

		public Object getRoot()
		{return root;}
		

		public Object getChild(Object parent, int index)
		{
			List list = children(parent);
			if(list==null || list.size()<=index) return null;
			return list.get(index);
		}
		
		public int getIndexOfChild(Object parent, Object child)
		{
			List list = children(parent);
			if(list==null) return -1;
			return list.indexOf(child);
		}

		public int getChildCount(Object parent)
		{
			List list = children(parent);
			if(list==null) return 0;
			return list.size();
		}

		public boolean isLeaf(Object node)
		{
			List list = children(node);
			return list==null || list.isEmpty();
		}
		

		public void addTreeModelListener(TreeModelListener l) {}
		public void removeTreeModelListener(TreeModelListener l) {}
		public void valueForPathChanged(TreePath path, Object newValue) {}
	}
	
	
	private List children(Object parent)
	{
		if(parent instanceof Map.Entry)
		{
			Map.Entry entry = (Map.Entry) parent;
			return children(entry.getValue());
		}
		if(parent instanceof Map)
		{
			Map map = (Map) parent;
			List l = new ArrayList(map.entrySet());
			Collections.sort(l,entryComparator);
			return l;
		}
		if(parent instanceof List)
		{
			return (List) parent;
		}
		return null;
	}
}
