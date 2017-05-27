package gus06.entity.gus.swing.frame.show.tree;

import gus06.framework.*;
import javax.swing.tree.TreeModel;

public class EntityImpl implements Entity, T, V, P {

	public String creationDate() {return "20161221";}


	private Service show;
	private Service newViewer;
	private Service findTreeModel;


	public EntityImpl() throws Exception
	{
		show = Outside.service(this,"gus.swing.frame.show");
		newViewer = Outside.service(this,"factory#gus.data.viewer.treemodel");
		findTreeModel = Outside.service(this,"gus.find.treemodel");
	}
	
	
	
	private Object comp(Object obj) throws Exception
	{
		TreeModel model = (TreeModel) findTreeModel.t(obj);
		Object viewer = newViewer.g();
		((P)viewer).p(model);
		return ((I)viewer).i();
	}
	
	
	public void p(Object obj) throws Exception
	{show.p(comp(obj));}
	
	public void v(String key, Object obj) throws Exception
	{show.v(key,comp(obj));}
	
	public Object t(Object obj) throws Exception
	{return show.t(comp(obj));}
}
