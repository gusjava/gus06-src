package gus06.entity.gus.swing.tree.perform.file.open;

import gus06.framework.*;
import javax.swing.JTree;
import java.io.File;
import javax.swing.tree.TreeModel;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140917";}


	private Service open;
	private Service selectionToList;


	public EntityImpl() throws Exception
	{
		open = Outside.service(this,"gus.awt.desktop.open.listfiles");
		selectionToList = Outside.service(this,"gus.swing.tree.selection.tofileslist");
	}
	
	
	public void p(Object obj) throws Exception
	{
		List files = treeToSelection((JTree) obj);
		if(!files.isEmpty()) open.p(files);
	}
	
	private List treeToSelection(JTree tree) throws Exception
	{return (List) selectionToList.t(tree);}
}
