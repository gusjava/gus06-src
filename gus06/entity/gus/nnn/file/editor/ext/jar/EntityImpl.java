package gus06.entity.gus.nnn.file.editor.ext.jar;

import gus06.framework.*;

import java.io.File;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class EntityImpl implements Entity, I, P, TreeSelectionListener {

	public String creationDate() {return "20140807";}


	public static final String DELIM = "/";
	
	private JTree tree;
	private JScrollPane scroll;
	
	private File file;
	private JarFile jarFile;


	public EntityImpl() throws Exception
	{
		tree = new JTree(new DefaultTreeModel(null));
		tree.setRootVisible(false);
		tree.addTreeSelectionListener(this);
		
		scroll = new JScrollPane(tree);
	}
	
	
	public Object i() throws Exception
	{return scroll;}
	
	
	
	public void valueChanged(TreeSelectionEvent e)
	{}
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		if(file==null) {resetGui();return;}
		
		jarFile = new JarFile(file,true,JarFile.OPEN_READ);

		ArrayList entries = new ArrayList();
		Enumeration en = jarFile.entries();
		while(en.hasMoreElements())
		{
			JarEntry entry = (JarEntry)en.nextElement();
			entries.add(entry.getName());
		}
		Collections.sort(entries);
		entries.add(0,"");
            
		JarEntryTreeNode root = new JarEntryTreeNode(entries,null);
		tree.setModel(new DefaultTreeModel(root));
		
		jarFile.close();
	}
	
	
	
	private void resetGui()
	{
		jarFile = null;
		tree.setModel(new DefaultTreeModel(null));
	}
	
	
	
	

	
	
	
	
	private String firstElement(ArrayList list)
	{return (String) list.get(0);}
    
    
	private String lastPart(JarEntryTreeNode parent, String name)
	{
		if(name.endsWith(DELIM)) name = name.substring(0,name.length()-1);
		return name.substring(parent.getEntryName().length());
	}

    
	private boolean isParent(String parent, String child)
	{
		if(!parent.equals("") && !parent.endsWith(DELIM)) parent = parent+DELIM;
		if(child.endsWith(DELIM)) child = child.substring(0,child.length()-1);
    	
		if(!child.startsWith(parent)) return false;
		String lastPart = child.substring(parent.length());
		return !lastPart.contains(DELIM);
	}
    
    
	private String findParent(String child)
	{
		if(child.endsWith(DELIM)) child = child.substring(0,child.length()-1);
		if(!child.contains(DELIM)) return "";
		String[] n = child.split(DELIM);
		int l = n[n.length-1].length();
		return child.substring(0,child.length()-l);
	}
	
	
	
	
	
	
	
	
	
	
	
	private class JarEntryTreeNode implements TreeNode
	{
		private String entryName;
		private ArrayList children;
		private JarEntryTreeNode parent;
		private String display;
    	
    	
		public JarEntryTreeNode(ArrayList entries, JarEntryTreeNode parent) throws Exception
		{
			this.entryName = firstElement(entries);
			this.display = entryName.equals("")?"ROOT":lastPart(parent,entryName);
			this.parent = parent;
			entries.remove(0);
    		
			children = new ArrayList();
			while(!entries.isEmpty() && firstElement(entries).startsWith(entryName))
				addNewChild(entries);
		}

    	
		private void addNewChild(ArrayList entries) throws Exception
		{
			String firstElement = firstElement(entries);
			while(!isParent(entryName,firstElement))
			{
				String firstElementParent = findParent(firstElement);
				entries.add(0,firstElementParent);
				firstElement = firstElement(entries);
			}
			children.add(new JarEntryTreeNode(entries,this));
		}
    	
    	
		public Enumeration children()
		{return Collections.enumeration(children);}

		public boolean getAllowsChildren()
		{return false;}

		public TreeNode getChildAt(int index)
		{return (TreeNode) children.get(index);}

		public int getChildCount()
		{return children.size();}

		public int getIndex(TreeNode node)
		{return children.indexOf(node);}

		public TreeNode getParent()
		{return parent;}

		public boolean isLeaf()
		{return !entryName.equals("") && !entryName.endsWith(DELIM);}
		
		public String toString()
		{return display;}
		
		public String getEntryName()
		{return entryName;}
	}
}