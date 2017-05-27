package gus06.entity.gus.dir.explorer.simple.tree;

import javax.swing.event.*;
import javax.swing.tree.*;

import java.io.*;
import java.util.*;


class ExplorerTreeModelCache implements TreeModel {

    
    
    private ExplorerTreeModel model;
	private Map cache;
	
	
	
	public ExplorerTreeModelCache()
	{
		model = new ExplorerTreeModel();
		cache = new HashMap();
	}
	
	public ExplorerTreeModelCache(File root)
	{
		model = new ExplorerTreeModel(root);
		cache = new HashMap();
	}
	

	public synchronized void setRoot(File root)
	{model.setRoot(root);}
	
	public synchronized Object getRoot()
	{return model.getRoot();}
	
	
	
	private Object[] getArray(Object node)
	{
		if(node==null) return null;
		if(!cache.containsKey(node))
		{
			int nb = model.getChildCount(node);
			if(nb==-1) return null;
			cache.put(node,new Object[nb]);
		}
		return (Object[]) cache.get(node);
	}

	
	
	public synchronized Object getChild(Object node, int index)
	{
		Object[] a = getArray(node);
		if(a==null) return null;
		if(a[index] == null) a[index] = model.getChild(node,index);
		return a[index];
	}

	
	public synchronized int getChildCount(Object node)
	{
		Object[] a = getArray(node);
		if(a==null) return 0;
		return a.length;
	}

	
	public synchronized boolean isLeaf(Object node)
	{
		Object[] a = getArray(node);
		if(a==null) return false;
		return a.length==0;
	}

	
	public synchronized int getIndexOfChild(Object node, Object child)
	{
		Object[] a = getArray(node);
		if(a==null || child==null) return -1;
		
		int nb = a.length;
		for(int i=0;i<nb;i++)
		if(a[i]!=null && a[i].equals(child)) return i;
		return -1;
	}
	
	

	
	public synchronized void valueForPathChanged(TreePath path, Object newValue)
	{
		cache.clear();
		model.valueForPathChanged(path,newValue);
	}
	
	public synchronized void addTreeModelListener(TreeModelListener listener)
	{model.addTreeModelListener(listener);}
	
	public synchronized void removeTreeModelListener(TreeModelListener listener)
	{model.removeTreeModelListener(listener);}
}
