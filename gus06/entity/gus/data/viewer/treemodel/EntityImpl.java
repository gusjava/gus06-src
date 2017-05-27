package gus06.entity.gus.data.viewer.treemodel;

import gus06.framework.*;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20161221";}


	private Service renderer;

	private TreeModel model;
	private JTree tree;


	public EntityImpl() throws Exception
	{
		renderer = Outside.service(this,"gus.swing.tree.cust.renderer.obj1");
		
		tree = new JTree();
		renderer.p(tree);
	}
	
	
	public Object g() throws Exception
	{return model;}
	
	
	public Object i() throws Exception
	{return tree;}
	
	
	public void p(Object obj) throws Exception
	{
		model = (TreeModel) obj;
		tree.setModel(model);
	}
}
