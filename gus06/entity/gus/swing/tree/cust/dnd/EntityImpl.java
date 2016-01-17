package gus06.entity.gus.swing.tree.cust.dnd;

import gus06.framework.*;
import javax.swing.JTree;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141213";}

	private Service dnd;
	
	public EntityImpl() throws Exception
	{dnd = Outside.service(this,"gus.awt.dnd");}
	
	
	public void p(Object obj) throws Exception
	{
		JTree tree = (JTree) obj;
		
		dnd.v("g",new DndHandler(tree));
		dnd.v("p",null);
		dnd.p(tree);
	}
	
	
	private class DndHandler implements G
	{
		private JTree tree;

		public DndHandler(JTree tree)
		{this.tree = tree;}

		public Object g() throws Exception
		{return tree.getLastSelectedPathComponent();}
	}
}
