package gus06.entity.gus.sys.filetool.ext.dirsizeviewer1.holder;

import gus06.framework.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.util.Map;
import java.io.File;
import javax.swing.JTree;
import javax.swing.JComponent;

public class EntityImpl implements Entity, I, P, Runnable {

	public String creationDate() {return "20161116";}
	
	
	private Service findRoot;
	private Service buildButton;
	private Service computeSizes;
	private Service buildTreeTable;
	private Service treeExplorer;
	private Service treeRenderer;
	private Service dataHolder;
	
	private JPanel panel;
	private JButton button;
	
	private Map map;
	private File root;
	
	private Thread t;
	


	public EntityImpl() throws Exception
	{
		findRoot = Outside.service(this,"gus.sys.filetool.findroot");
		buildButton = Outside.service(this,"gus.swing.button.build.runnable");
		computeSizes = Outside.service(this,"gus.dir.listing.dirtomap.file_size");
		buildTreeTable = Outside.service(this,"gus.sys.treetable1.filesize");
		treeExplorer = Outside.service(this,"*gus.dir.explorer.simple.tree");
		treeRenderer = Outside.service(this,"gus.dir.explorer.treerenderer1");
		dataHolder = Outside.service(this,"*gus.data.holder0");
		
		JTree tree = (JTree) treeExplorer.i();
		treeRenderer.p(tree);
		
		JComponent comp = (JComponent) buildTreeTable.t(new Object[]{tree,dataHolder});
		
		button = (JButton) buildButton.t(this);
		button.setText("analyze");
		
		panel = new JPanel(new BorderLayout());
		panel.add(comp,BorderLayout.CENTER);
		panel.add(button,BorderLayout.SOUTH);
		
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		map = (Map) obj;
		root = (File) findRoot.t(map);
		
		treeExplorer.p(root);
		dataHolder.p(null);
	}
	
	
	public void run()
	{perform();}
	
	
	
	
	private void perform()
	{
		try
		{
			if(root==null || !root.isDirectory()) return;
			
			Map map = (Map) computeSizes.t(root);
			dataHolder.p(map);
		}
		catch(Exception e)
		{Outside.err(this,"perform()",e);}
	}
}
