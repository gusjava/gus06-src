package gus06.entity.gus.dir.explorer.simple.tree;

import javax.swing.event.*;
import javax.swing.tree.*;

import java.io.*;
import java.util.*;


class ExplorerTreeModel implements TreeModel {

    
    
    
    public static final int NB_LIMIT = 1000;
	private File root = null;
	
	
	
	public ExplorerTreeModel(){}
	
	public ExplorerTreeModel(File root)
	{this.root = root;}
	

	public void setRoot(File root)
	{this.root = root;}
	
	public Object getRoot()
	{return clone(root);}

	
	public Object getChild(Object node, int index)
	{
		File f = clone(node);
		File[] children = f.listFiles();
		return children[index];
	}

	
	public int getChildCount(Object node)
	{
		File f = clone(node);
		if(f==null) return 0;
		
		File[] children = f.listFiles();
		if(children==null) return 0;
		
		int n = children.length;
		if(n>NB_LIMIT)return 0;
		
		return n;
	}

	
	public boolean isLeaf(Object node)
	{
		File f = clone(node);
		return f.isFile() || isEmptyDir(f);
	}

	
	public int getIndexOfChild(Object node, Object child)
	{
		if(child instanceof String) return 0;
	    
		File f = clone(node);
		File[] children = f.listFiles();
		return Arrays.binarySearch(children,child);
	}

	
	private File clone(Object obj)
	{
		if(obj==null) return null;
		return new File(obj.toString());
	}
	
	
	
	private boolean isEmptyDir(File f)
	{
		if(!f.isDirectory()) return false;
		File[] ff = f.listFiles();
		return ff==null || ff.length==0;
	}
	
	
	
	
	public void valueForPathChanged(TreePath path, Object newValue)
	{fireTreeStructureChanged(this,path);}
	
	private EventListenerList listenerList = new EventListenerList();
	
	public synchronized void addTreeModelListener(TreeModelListener listener)
	{listenerList.add(TreeModelListener.class,listener);}
	
	public synchronized void removeTreeModelListener(TreeModelListener listener)
	{listenerList.remove(TreeModelListener.class, listener);}

	protected void fireTreeStructureChanged(Object source, TreePath path)
	{
	    Object[] listeners = listenerList.getListenerList();
	    TreeModelEvent e = null;
	    
	    for(int i=listeners.length-2; i>=0; i-=2)
	    if(listeners[i]==TreeModelListener.class)
	    {
	        if(e==null) e = new TreeModelEvent(source, path);
	        ((TreeModelListener)listeners[i+1]).treeStructureChanged(e);
	    }          
	}
	
	
	
}
