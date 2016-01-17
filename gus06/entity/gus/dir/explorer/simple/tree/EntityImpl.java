package gus06.entity.gus.dir.explorer.simple.tree;

import java.io.File;

import gus06.framework.*;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class EntityImpl extends S1 implements Entity, I, G, P, E, TreeSelectionListener {

	public String creationDate() {return "20140724";}



	private JTree1 tree;
	private File dir;
    
	public EntityImpl() throws Exception
	{
		tree = new JTree1();
		tree.addTreeSelectionListener(this);
	}
	
	
	public Object i() throws Exception
	{return tree;}
	
	
	
	public Object g() throws Exception
	{return tree.getLastSelectedPathComponent();}
	
	
	
	public void p(Object obj) throws Exception
	{
		dir = (File) obj;
		if(dir!=null && !dir.isDirectory()) throw new Exception("Invalid path: "+dir);
		tree.e();
	}
	
	
	public void e() throws Exception
	{tree.e();}
    
	
    
	
    
	public void valueChanged(TreeSelectionEvent evt)
	{
		if(tree.isSelectionEmpty())return;
		fileSelected();
	}
	
	
	private void fileSelected()
	{send(this,"fileSelected()");}
	
	
	
	
	
	
	
	private class JTree1 extends JTree implements E
	{
		public JTree1()
		{super(new ExplorerTreeModelCache(null));}
		
		public void e() throws Exception
		{setModel(new ExplorerTreeModelCache(dir));}
	}
}
