package gus06.entity.gus.sys.helpviewer1.gui.tree;

import gus06.framework.*;
import javax.swing.JTree;
import java.util.Map;
import javax.swing.tree.TreeModel;
import javax.swing.JScrollPane;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class EntityImpl extends S1 implements Entity, I, P, G, TreeSelectionListener {

	public String creationDate() {return "20161022";}


	private Service parser;
	private Service buildModel;
	private Service renderer;
	private Service expandUI;

	private JTree tree;
	private JScrollPane scroll;
	private TreeModel model;
	

	public EntityImpl() throws Exception
	{
		parser = Outside.service(this,"gus.sys.treeparser1.engine");
		buildModel = Outside.service(this,"gus.swing.tree.model.build.frommap");
		renderer = Outside.service(this,"gus.sys.helpviewer1.gui.tree.renderer");
		expandUI = Outside.service(this,"gus.swing.tree.cust.ui.expandcollapseicons");
		
		tree = new JTree();
		tree.setRootVisible(false);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(this);
		expandUI.p(tree);
		
		scroll = new JScrollPane(tree);
	}
	
	
	public Object g() throws Exception
	{
		if(tree.isSelectionEmpty()) return null;
		return tree.getLastSelectedPathComponent();
	}
	
	
	public Object i() throws Exception
	{return scroll;}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		if(model!=null) throw new Exception("TreeModel is already initialized");
		
		String content = (String) obj;
		Map map = (Map) parser.t(content);
		model = (TreeModel) buildModel.t(map);
		tree.setModel(model);
		
		renderer.p(tree);
		
		tree.expandRow(0);
	}
	
	
	
	public void valueChanged(TreeSelectionEvent evt)
	{
		if(tree.isSelectionEmpty()) return;
                selected();
	}
	
	
	private void selected()
	{send(this,"selected()");}
}
