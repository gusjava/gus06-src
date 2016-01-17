package gus06.entity.gus.swing.tree.build.fromicon;

import gus06.framework.*;
import javax.swing.JTree;
import javax.swing.tree.TreeSelectionModel;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140917";}


	private Service renderer;
	private Service custUI;
	
	public EntityImpl() throws Exception
	{
		renderer = Outside.service(this,"gus.swing.tree.cust.renderer1");
		custUI = Outside.service(this,"gus.swing.tree.cust.ui.expandcollapseicons");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		JTree tree = new JTree();
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		renderer.v("icon",obj);
		renderer.v("color",null);
		renderer.p(tree);
		
		custUI.p(tree);
		return tree;
	}
}
